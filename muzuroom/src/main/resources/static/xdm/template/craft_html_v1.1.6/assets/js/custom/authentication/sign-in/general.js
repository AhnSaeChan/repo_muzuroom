"use strict";

// Class definition
var KTSigninGeneral = function () {
    // Elements
    var form;
    var submitButton;
    var validator;

    // Handle form
    var handleValidation = function (e) {
        // Init form validation rules. For more info check the FormValidation plugin's official documentation:https://formvalidation.io/
        validator = FormValidation.formValidation(
            form,
            {
                fields: {
                    'id': {
                        validators: {
                            regexp: {
                                regexp: /^[a-zA-Z][a-zA-Z0-9._]{0,29}$/,
                                message: '영문, 숫자만 사용해 주세요',
                            },
                            notEmpty: {
                                message: 'id를 입력해 주세요'
                            }
                        }
                    },
                    'password': {
                        validators: {
                            notEmpty: {
                                message: '비밀번호를 입력해 주세요'
                            }
                        }
                    }
                },
                plugins: {
                    trigger: new FormValidation.plugins.Trigger(),
                    bootstrap: new FormValidation.plugins.Bootstrap5({
                        rowSelector: '.fv-row',
                        eleInvalidClass: '',  // comment to enable invalid state icons
                        eleValidClass: '' // comment to enable valid state icons
                    })
                }
            }
        );
    }

    var handleSubmitDemo = function (e) {
        // Handle form submit
        submitButton.addEventListener('click', function (e) {
            // Prevent button default action
            e.preventDefault();

            // Validate form
            validator.validate().then(function (status) {
                
            });
        });
    }

    

    var isValidUrl = function(url) {
        try {
            new URL(url);
            return true;
        } catch (e) {
            return false;
        }
    }

    // Public functions
    return {
        // Initialization
        init: function () {
            form = document.querySelector('#kt_sign_in_form');
            submitButton = document.querySelector('#buttonSignIn');

            handleValidation();

            if (isValidUrl(submitButton.closest('form').getAttribute('action'))) {
                handleSubmitAjax(); // use for ajax submit
            } else {
                handleSubmitDemo(); // used for demo purposes only
            }
        }
    };
}();

// On document ready
KTUtil.onDOMContentLoaded(function () {
    KTSigninGeneral.init();
});
