package com.arturo.email.dto;

public record EmailRequest (String email,
                            String firstName,
                            String gender,
                            String birth,
                            boolean newsletter,
                            String newsLetterId){


}
