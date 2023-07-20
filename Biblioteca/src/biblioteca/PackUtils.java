package biblioteca;

public class PackUtils {

    public static void packBoolean(boolean b, byte[] buffer, int offset) {
        if (b) {
            buffer[offset] = (byte) 1;
        } else {
            buffer[offset] = (byte) 0;
        }
    }

    public static boolean unpackBoolean(byte[] buffer, int offset) {
        return buffer[offset] == (byte) 1;
    }

    public static void packChar(char c, byte[] buffer, int offset) {
        buffer[offset] = (byte) (0xFF & (c >> 8));
        buffer[offset + 1] = (byte) (0xFF & c);
    }

    public static char unpackChar(byte[] buffer, int offset) {
        return (char) ((buffer[offset] << 8) | (buffer[offset + 1] & 0xFF));
    }

    public static void packLimitedString(String str, int maxLength, byte[] buffer, int offset) {
        for (int i = 0; i < maxLength; i++) {
            if (i < str.length()) {
                packChar(str.charAt(i), buffer, offset + 2 * i);
            } else {
                // We mark with a zero
                packChar('\0', buffer, offset + 2 * i);
                break;
            }
        }
    }

    public static String unpackLimitedString(int maxLength, byte[] buffer, int offset) {
        String result = "";
        for (int i = 0; i < maxLength; i++) {
            {
                char c = unpackChar(buffer, offset + 2 * i);
                if (c != '\0') {
                    result += c;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void packInt(int n, byte[] buffer, int offset) {
        buffer[offset] = (byte) (n >> 24);
        buffer[offset + 1] = (byte) (n >> 16);
        buffer[offset + 2] = (byte) (n >> 8);
        buffer[offset + 3] = (byte) (n);
    }

    public static int unpackInt(byte[] buffer, int offset) {
        return ((buffer[offset] & 0xFF) << 24)
                | ((buffer[offset + 1] & 0xFF) << 16)
                | ((buffer[offset + 2] & 0xFF) << 8)
                | (buffer[offset + 3] & 0xFF);
    }

    public static void packLong(long n, byte[] buffer, int offset) {
        buffer[offset] = (byte) (n >> 56);
        buffer[offset + 1] = (byte) (n >> 48);
        buffer[offset + 2] = (byte) (n >> 40);
        buffer[offset + 3] = (byte) (n >> 32);
        buffer[offset + 4] = (byte) (n >> 24);
        buffer[offset + 5] = (byte) (n >> 16);
        buffer[offset + 6] = (byte) (n >> 8);
        buffer[offset + 7] = (byte) (n);
    }

    public static long unpackLong(byte[] buffer, int offset) {
        return ((long) (buffer[offset] & 0xFF) << 56)
                | ((long) (buffer[offset + 1] & 0xFF) << 48)
                | ((long) (buffer[offset + 2] & 0xFF) << 40)
                | ((long) (buffer[offset + 3] & 0xFF) << 32)
                | ((long) (buffer[offset + 4] & 0xFF) << 24)
                | ((long) (buffer[offset + 5] & 0xFF) << 16)
                | ((long) (buffer[offset + 6] & 0xFF) << 8)
                | ((long) (buffer[offset + 7] & 0xFF));
    }

    public static void packDouble(double n, byte[] buffer, int offset) {
        long bits = Double.doubleToRawLongBits(n);
        packLong(bits, buffer, offset);
    }

    public static double unpackDouble(byte[] buffer, int offset) {
        long bits = unpackLong(buffer, offset);
        return Double.longBitsToDouble(bits);
    }
}
