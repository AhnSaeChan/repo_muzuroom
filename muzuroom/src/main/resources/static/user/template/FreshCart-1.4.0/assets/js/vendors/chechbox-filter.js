function updateCheckboxCount(e){var t=e.querySelectorAll(".form-check-input"),t=Array.from(t).filter(e=>e.checked).length,e=e.getAttribute("data-dropdown");document.querySelector(`.dropdownButton[data-dropdown="${e}"]`).textContent=e.charAt(0).toUpperCase()+e.slice(1)+` (${t})`}document.querySelectorAll(".dropdownSelect").forEach(t=>{t.querySelectorAll(".form-check-input").forEach(e=>{e.addEventListener("change",()=>updateCheckboxCount(t))})});