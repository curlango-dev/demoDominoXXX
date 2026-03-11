package uabc.curlango.demodominoxxx;

/**
 * Modela una ficha de dominó. Contiene un String
 * que es un emoji de la ficha.
 * @author Cecilia M. Curlango Rosas
 * @version marzo 2026
 */
public class FichaEmoji  {
    private Ficha ficha;
    private static final int EMOJI_HORIZONTAL = 0x1F031;
    private static final int EMOJI_VERTICAL = 0x1F071;
    protected String emoji;

    public FichaEmoji(int ladoA, int ladoB) {
        ficha = new Ficha(ladoA, ladoB);
        int dominoValue = EMOJI_HORIZONTAL + (ladoA * 7) + ladoB;
        emoji = new String(Character.toChars(dominoValue));
    }

    /**
     * Regesa el emoji que corresponde a la ficha y su estado.
     * @return String con emoji de la ficha.
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Intercambia los lados de la ficha y actualiza
     * el emoji para que refleje este nuevo estado.
     */

    public void intercambiarLados() {
        ficha.voltear();
        // Cambia el emoji de la ficha
        int dominoValue = EMOJI_HORIZONTAL
                + (ficha.getLadoA() * 7)
                + ficha.getLadoB();
        emoji = new String(Character.toChars(dominoValue));
    }
}
