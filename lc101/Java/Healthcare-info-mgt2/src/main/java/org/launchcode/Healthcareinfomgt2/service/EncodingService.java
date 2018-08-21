package org.launchcode.Healthcareinfomgt2.service;

import org.springframework.stereotype.Service;

@Service
public class EncodingService {

    public final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUWVXYZ";
    public final Integer rotateBy = 12;

    public int findPosition(char letter){
        return ALPHABETS.indexOf(Character.toUpperCase(letter));
    }

    public String encode(String input) {
        String encryptedString = "";
        int ascii;
        int new_position = 0;
        for (int i = 0; i < input.length(); i++) {
            ascii = input.charAt(i);
            if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                new_position = (findPosition(input.charAt(i)) + rotateBy) % 26;

                if (ascii >= 65 && ascii <= 90) {
                    encryptedString = encryptedString + Character.toUpperCase(ALPHABETS.charAt(new_position));
                } else {
                    encryptedString = encryptedString + ALPHABETS.charAt(new_position);
                }
            } else {
                encryptedString = encryptedString + input.charAt(i);
            }
        }

        return encryptedString;
    }
}