package com.a6.module.userinfo;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a6.common.util.UtilDateTime;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Controller
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	MailService mailService;
	
	
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmList")
	public String UserInfoXdmList(@ModelAttribute("vo") UserInfoVo vo, Model model) {
	
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		if (vo.getShDelNy() == null) {
		    vo.setShDelNy(0);
		}
		
		vo.setParamsPaging(userInfoService.selectOneCount(vo));
		
//		int a = codeGroupService.selectOneCount();
//		model.addAttribute(vo);
		
		model.addAttribute("list",userInfoService.selectList(vo));
//		CodeGroupVo codeGroupVo = new CodeGroupVo();
//		codeGroupVo.setThisPage();
//		codeGroupVo.setRowNumToShow(20);
		
		
	
		 return "xdm/userinfo/UserInfoXdmList";
	}
	
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmForm")
	public String UserInfoXdmForm(Model model, UserInfoVo userInfoVo) {
		model.addAttribute("item",userInfoService.selectOne(userInfoVo));
		return "xdm/userinfo/UserInfoXdmForm";
	}
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmInst")
	public String UserInfoXdmInst(UserInfoDto userInfoDto, UserInfoVo vo) {
		
		
		String encryptedPw = encodeBcrypt(userInfoDto.getUserPassword(), 10);
	    userInfoDto.setUserPassword(encryptedPw); 
	    
	   Thread thread = new Thread(new Runnable() {
	    
		@Override
	    public void run() {
	    	
	    	try {
	    		mailService.sendMailWelcome();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	};
	    }
	   });
	    
	    thread.start();
	    
	    userInfoService.insert(userInfoDto);
		
		
		return "redirect:/xdm/userinfo/UserInfoXdmList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(UserInfoDto UserInfoDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		UserInfoDto rtMember = userInfoService.selectOneLogin(UserInfoDto);
		
		
		if(rtMember!=null) {
			
			
	        String inputPassword = UserInfoDto.getUserPassword();

	        
	        String hashedPassword = rtMember.getUserPassword();
	        
	        if (matchesBcrypt(inputPassword, hashedPassword, 10)) {
			httpSession.setAttribute("sessSeqXdm",rtMember.getSeq());
			httpSession.setAttribute("sessIdXdm",rtMember.getUserId());
			httpSession.setAttribute("sessNameXdm",rtMember.getUserName());
			returnMap.put("rt","success");
		}else {
			returnMap.put("rt","fail");
//			System.out.println(rtMember.getSeq());
		} 
		}else {
	        
	        returnMap.put("rt", "fail");
	    }

//		UtilCookie.deleteCookieXdm();
		
//		System.out.println(rtMember.getUserId());
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		UtilCookie.deleteCookieXdm();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt","success");
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinUsrProc")
	public Map<String, Object> signinUsrProc(UserInfoDto UserInfoDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		UserInfoDto rtMember = userInfoService.selectOneLogin(UserInfoDto);
			if(rtMember!=null) {
			
			
	        String inputPassword = UserInfoDto.getUserPassword();

	        
	        String hashedPassword = rtMember.getUserPassword();
	        
	        if (matchesBcrypt(inputPassword, hashedPassword, 10)) {
	        	
			httpSession.setAttribute("sessSeqUsr",rtMember.getSeq());
			httpSession.setAttribute("sessIdUsr",rtMember.getUserId());
			httpSession.setAttribute("sessNameUsr",rtMember.getUserName());
			httpSession.setAttribute("sessEmailUsr",rtMember.getUserEmail());
			httpSession.setAttribute("sessFirstNameUsr",rtMember.getUserFirstName());
			httpSession.setAttribute("sessGenderUsr",rtMember.getUserGenderMF());
			httpSession.setAttribute("sessPassUsr",rtMember.getUserPassword());
			httpSession.setAttribute("sessPhoneUsr",rtMember.getUserPhoneNum());
			httpSession.setAttribute("sessZipcodeUsr",rtMember.getUserZipcode());
			httpSession.setAttribute("sessAddressUsr",rtMember.getUserAddress());
			httpSession.setAttribute("sessStreetUsr",rtMember.getStreetAddress());
			httpSession.setAttribute("sessLotUsr",rtMember.getLotAddress());
			httpSession.setAttribute("sessAddRefUsr",rtMember.getAddressRef());
			httpSession.setAttribute("sessLatitudeUsr",rtMember.getLatitude());
			httpSession.setAttribute("sessLongitudeUsr",rtMember.getLongitude());
			httpSession.setAttribute("sessAdiminDistrictUsr",rtMember.getAdminDistrict());
			httpSession.setAttribute("sessMobileCarrierUsr",rtMember.getMobileCarrier());
			httpSession.setAttribute("sessgetUserDOBUsr",rtMember.getUserDOB());
			
			
			returnMap.put("rt","success");
		}else {
			returnMap.put("rt","fail");
//			System.out.println(rtMember.getSeq());
		} 
		}else {
	        
	        returnMap.put("rt", "fail");
	    }

//		UtilCookie.deleteCookieXdm();
		
//		System.out.println(rtMember.getUserId());
		return returnMap;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		UtilCookie.deleteCookieXdm();
		httpSession.setAttribute("sessSeqUsr", null);
		httpSession.setAttribute("sessIdUsr", null);
		httpSession.setAttribute("sessNameUsr", null);
		httpSession.setAttribute("sessEmail",null);
		httpSession.setAttribute("sessSeqUsr",null);
		httpSession.setAttribute("sessIdUsr",null);
		httpSession.setAttribute("sessNameUsr",null);
		httpSession.setAttribute("sessEmailUsr",null);
		httpSession.setAttribute("sessFirstNameUsr",null);
		httpSession.setAttribute("sessGenderUsr",null);
		httpSession.setAttribute("sessPassUsr",null);
		httpSession.setAttribute("sessPhoneUsr",null);
		httpSession.setAttribute("sessZipcodeUsr",null);
		httpSession.setAttribute("sessAddressUsr",null);
		httpSession.setAttribute("sessStreetUsr",null);
		httpSession.setAttribute("sessLotUsr",null);
		httpSession.setAttribute("sessAddRefUsr",null);
		httpSession.setAttribute("sessLatitudeUsr",null);
		httpSession.setAttribute("sessLongitudeUsr",null);
		httpSession.setAttribute("sessAdiminDistrictUsr",null);
		httpSession.setAttribute("sessMobileCarrierUsr",null);
		httpSession.setAttribute("sessgetUserDOBUsr",null);
		returnMap.put("rt","success");
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectDuplicateId")
	public Map<String, Object> selectDuplicateId(UserInfoDto UserInfoDto) throws Exception {
	    Map<String, Object> returnMap = new HashMap<>();
	    
	    int cheakId = userInfoService.selectDuplicateId(UserInfoDto); 
	    returnMap.put("rt", cheakId > 0 ? "fail" : "success");
	    
	    return returnMap;
	}
	
	//암호화 코드
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
	//회원가입
	@RequestMapping(value = "/usrSignUpForm")
	public String usrSignUpForm() {
		
		return "usr/usrsignup/usrSignUpForm";
	}
	
	@RequestMapping(value = "/usrMyInfoMod")
	public String usrMyInfoMod(Model model, UserInfoVo userInfoVo, HttpSession session) {
		
		model.addAttribute("vo", userInfoVo);
		
		model.addAttribute("list",userInfoService.selectList(userInfoVo));
		return "usr/myaccount/usrMyInfoMod";
	}
	
	@RequestMapping(value = "/updateInfo")
	public String updateInfo(UserInfoDto userInfoDto) {
		
		 System.out.println(userInfoDto.getSeq());
		
		userInfoService.updateInfo(userInfoDto);
		
		return "redirect:/usrMyInfoMod";
		
	}
	
	@RequestMapping(value = "/userInfoXdmExcel")
	public void exportBlogsToCsv(HttpServletResponse response,UserInfoVo vo) throws Exception {
		vo.setParamsPaging(userInfoService.selectOneCount(vo));
	    List<UserInfoDto> users = userInfoService.selectList(vo);

	    response.setContentType("text/xls; charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment; filename = users.xls");
	   
	    PrintWriter writer = response.getWriter();
	    writer.write('\uFEFF');  //윈도우 사용자 한글깨짐 방지
	    writer.println("#,성,이름,성별,ID,PASSWORD,통신사,전화번호,주거구역,전자메일,생년월일,등록일자");

	    for (UserInfoDto user : users) {
	        writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
	        		user.getSeq(),
	        		user.getUserFirstName(),
	        		user.getUserName(),
	        		user.getUserGenderMF(),
	        		user.getUserId(),
	        		user.getUserPassword(),
	        		user.getMobileCarrier(),
	        		user.getUserPhoneNum(),
	        		user.getAdminDistrict(),
	        		user.getUserEmail(),
	        		user.getUserDOB(),
	        		user.getUserRegDate()
	        );
	    }
	    writer.flush();
	    writer.close();
	}
	
	
	
	
	
	
	
}
