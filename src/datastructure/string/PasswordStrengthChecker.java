package datastructure.string;

public class PasswordStrengthChecker {
    private String password;

    public PasswordStrengthChecker(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isStrong() {
        return hasMinimumLength() && containsUppercase()
                && containsLowercase() && containsDigit()
                && containsSpecialCharacter();
    }

    private boolean hasMinimumLength() {
        return password.length() >= 8;
    }

    private boolean containsUppercase() {
        return !password.equals(password.toLowerCase());
    }

    private boolean containsLowercase() {
        return !password.equals(password.toUpperCase());
    }

    private boolean containsDigit() {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter() {
        String specialCharacters = "!@#$%^&*()-+";
        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PasswordStrengthChecker strongPasswordChecker = new PasswordStrengthChecker("StrongP@ss123");
        PasswordStrengthChecker weakPasswordChecker = new PasswordStrengthChecker("weak123");

        System.out.println("Is \"" + strongPasswordChecker.getPassword() + "\" a strong password? " + strongPasswordChecker.isStrong());
        System.out.println("Is \"" + weakPasswordChecker.getPassword() + "\" a strong password? " + weakPasswordChecker.isStrong());
    }
}
