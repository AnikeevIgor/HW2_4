public class Loopchecker implements Checker {

    private static final String VALID_CHARACTERS = "0123456789_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";


    @Override
    public void check(String s, boolean login) throws loginExp, passwordExp {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                if (login) {
                    throw new loginExp("Параметр Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
                } else {
                    throw new passwordExp("Параметр Password должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
                }
            }
        }
    }
}