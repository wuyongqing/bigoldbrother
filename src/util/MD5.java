package util;

import java.security.DigestException;
import java.security.MessageDigestSpi;

public final class MD5 extends MessageDigestSpi implements Cloneable {

    private byte[] digestBits;
    private int[] state;
    private long count;
    private byte[] buffer;
    private int[] transformBuffer;

    public MD5() {
        this.init();
    }

    private MD5(MD5 md5) {
        this();
        this.state = (int[]) ((int[]) md5.state.clone());
        this.transformBuffer = (int[]) ((int[]) md5.transformBuffer.clone());
        this.buffer = (byte[]) ((byte[]) md5.buffer.clone());
        this.digestBits = (byte[]) ((byte[]) md5.digestBits.clone());
        this.count = md5.count;
    }

    private int FF(int i, int j, int k, int l, int i1, int j1, int k1) {
        i += (j & k | ~j & l) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private int GG(int i, int j, int k, int l, int i1, int j1, int k1) {
        i += (j & l | k & ~l) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private int HH(int i, int j, int k, int l, int i1, int j1, int k1) {
        i += (j ^ k ^ l) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private int II(int i, int j, int k, int l, int i1, int j1, int k1) {
        i += (k ^ (j | ~l)) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    void transform(byte[] abyte0, int i) {
        int[] ai = this.transformBuffer;
        int j = this.state[0];
        int k = this.state[1];
        int l = this.state[2];
        int i1 = this.state[3];

        for (int j1 = 0; j1 < 16; ++j1) {
            ai[j1] = abyte0[j1 * 4 + i] & 255;

            for (int k1 = 1; k1 < 4; ++k1) {
                ai[j1] += (abyte0[j1 * 4 + k1 + i] & 255) << k1 * 8;
            }
        }

        j = this.FF(j, k, l, i1, ai[0], 7, -680876936);
        i1 = this.FF(i1, j, k, l, ai[1], 12, -389564586);
        l = this.FF(l, i1, j, k, ai[2], 17, 606105819);
        k = this.FF(k, l, i1, j, ai[3], 22, -1044525330);
        j = this.FF(j, k, l, i1, ai[4], 7, -176418897);
        i1 = this.FF(i1, j, k, l, ai[5], 12, 1200080426);
        l = this.FF(l, i1, j, k, ai[6], 17, -1473231341);
        k = this.FF(k, l, i1, j, ai[7], 22, -45705983);
        j = this.FF(j, k, l, i1, ai[8], 7, 1770035416);
        i1 = this.FF(i1, j, k, l, ai[9], 12, -1958414417);
        l = this.FF(l, i1, j, k, ai[10], 17, -42063);
        k = this.FF(k, l, i1, j, ai[11], 22, -1990404162);
        j = this.FF(j, k, l, i1, ai[12], 7, 1804603682);
        i1 = this.FF(i1, j, k, l, ai[13], 12, -40341101);
        l = this.FF(l, i1, j, k, ai[14], 17, -1502002290);
        k = this.FF(k, l, i1, j, ai[15], 22, 1236535329);
        j = this.GG(j, k, l, i1, ai[1], 5, -165796510);
        i1 = this.GG(i1, j, k, l, ai[6], 9, -1069501632);
        l = this.GG(l, i1, j, k, ai[11], 14, 643717713);
        k = this.GG(k, l, i1, j, ai[0], 20, -373897302);
        j = this.GG(j, k, l, i1, ai[5], 5, -701558691);
        i1 = this.GG(i1, j, k, l, ai[10], 9, 38016083);
        l = this.GG(l, i1, j, k, ai[15], 14, -660478335);
        k = this.GG(k, l, i1, j, ai[4], 20, -405537848);
        j = this.GG(j, k, l, i1, ai[9], 5, 568446438);
        i1 = this.GG(i1, j, k, l, ai[14], 9, -1019803690);
        l = this.GG(l, i1, j, k, ai[3], 14, -187363961);
        k = this.GG(k, l, i1, j, ai[8], 20, 1163531501);
        j = this.GG(j, k, l, i1, ai[13], 5, -1444681467);
        i1 = this.GG(i1, j, k, l, ai[2], 9, -51403784);
        l = this.GG(l, i1, j, k, ai[7], 14, 1735328473);
        k = this.GG(k, l, i1, j, ai[12], 20, -1926607734);
        j = this.HH(j, k, l, i1, ai[5], 4, -378558);
        i1 = this.HH(i1, j, k, l, ai[8], 11, -2022574463);
        l = this.HH(l, i1, j, k, ai[11], 16, 1839030562);
        k = this.HH(k, l, i1, j, ai[14], 23, -35309556);
        j = this.HH(j, k, l, i1, ai[1], 4, -1530992060);
        i1 = this.HH(i1, j, k, l, ai[4], 11, 1272893353);
        l = this.HH(l, i1, j, k, ai[7], 16, -155497632);
        k = this.HH(k, l, i1, j, ai[10], 23, -1094730640);
        j = this.HH(j, k, l, i1, ai[13], 4, 681279174);
        i1 = this.HH(i1, j, k, l, ai[0], 11, -358537222);
        l = this.HH(l, i1, j, k, ai[3], 16, -722521979);
        k = this.HH(k, l, i1, j, ai[6], 23, 76029189);
        j = this.HH(j, k, l, i1, ai[9], 4, -640364487);
        i1 = this.HH(i1, j, k, l, ai[12], 11, -421815835);
        l = this.HH(l, i1, j, k, ai[15], 16, 530742520);
        k = this.HH(k, l, i1, j, ai[2], 23, -995338651);
        j = this.II(j, k, l, i1, ai[0], 6, -198630844);
        i1 = this.II(i1, j, k, l, ai[7], 10, 1126891415);
        l = this.II(l, i1, j, k, ai[14], 15, -1416354905);
        k = this.II(k, l, i1, j, ai[5], 21, -57434055);
        j = this.II(j, k, l, i1, ai[12], 6, 1700485571);
        i1 = this.II(i1, j, k, l, ai[3], 10, -1894986606);
        l = this.II(l, i1, j, k, ai[10], 15, -1051523);
        k = this.II(k, l, i1, j, ai[1], 21, -2054922799);
        j = this.II(j, k, l, i1, ai[8], 6, 1873313359);
        i1 = this.II(i1, j, k, l, ai[15], 10, -30611744);
        l = this.II(l, i1, j, k, ai[6], 15, -1560198380);
        k = this.II(k, l, i1, j, ai[13], 21, 1309151649);
        j = this.II(j, k, l, i1, ai[4], 6, -145523070);
        i1 = this.II(i1, j, k, l, ai[11], 10, -1120210379);
        l = this.II(l, i1, j, k, ai[2], 15, 718787259);
        k = this.II(k, l, i1, j, ai[9], 21, -343485551);
        this.state[0] += j;
        this.state[1] += k;
        this.state[2] += l;
        this.state[3] += i1;
    }

    public void init() {
        this.state = new int[4];
        this.transformBuffer = new int[16];
        this.buffer = new byte[64];
        this.digestBits = new byte[16];
        this.count = 0L;
        this.state[0] = 1732584193;
        this.state[1] = -271733879;
        this.state[2] = -1732584194;
        this.state[3] = 271733878;

        for (int i = 0; i < this.digestBits.length; ++i) {
            this.digestBits[i] = 0;
        }

    }

    public void engineReset() {
        this.init();
    }

    protected int engineGetDigestLength() {
        return 16;
    }

    public synchronized void engineUpdate(byte byte0) {
        int i = (int) (this.count >>> 3 & 63L);
        this.count += 8L;
        this.buffer[i] = byte0;
        if (i >= 63) {
            this.transform(this.buffer, 0);
        }

    }

    public synchronized void engineUpdate(byte[] abyte0) {
        this.engineUpdate(abyte0, 0, abyte0.length);
    }

    public synchronized void engineUpdate(byte[] abyte0, int i, int j) {
        int k = i;

        while (true) {
            while (j > 0) {
                int l = (int) (this.count >>> 3 & 63L);
                if (l == 0 && j > 64) {
                    this.count += 512L;
                    this.transform(abyte0, k);
                    j -= 64;
                    k += 64;
                } else {
                    this.count += 8L;
                    this.buffer[l] = abyte0[k];
                    if (l >= 63) {
                        this.transform(this.buffer, 0);
                    }

                    ++k;
                    --j;
                }
            }

            return;
        }
    }

    private void finish() {
        byte[] abyte0 = new byte[8];

        int k;
        for (k = 0; k < 8; ++k) {
            abyte0[k] = (byte) ((int) (this.count >>> k * 8 & 255L));
        }

        k = (int) (this.count >> 3) & 63;
        int l = k >= 56 ? 120 - k : 56 - k;
        byte[] abyte1 = new byte[l];
        abyte1[0] = -128;
        this.engineUpdate(abyte1, 0, abyte1.length);
        this.engineUpdate(abyte0, 0, abyte0.length);

        for (int j = 0; j < 4; ++j) {
            for (int i1 = 0; i1 < 4; ++i1) {
                this.digestBits[j * 4 + i1] = (byte) (this.state[j] >>> i1 * 8 & 255);
            }
        }

    }

    public byte[] engineDigest() {
        this.finish();
        byte[] abyte0 = new byte[16];
        System.arraycopy(this.digestBits, 0, abyte0, 0, 16);
        this.init();
        return abyte0;
    }

    public int engineDigest(byte[] abyte0, int i, int j) throws DigestException {
        this.finish();
        if (j < 16) {
            throw new DigestException("partial digests not returned");
        } else if (abyte0.length - i < 16) {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        } else {
            System.arraycopy(this.digestBits, 0, abyte0, i, 16);
            this.init();
            return 16;
        }
    }

    public Object clone() {
        MD5 md5 = null;

        try {
            md5 = (MD5) super.clone();
            md5.state = (int[]) ((int[]) this.state.clone());
            md5.transformBuffer = (int[]) ((int[]) this.transformBuffer.clone());
            md5.buffer = (byte[]) ((byte[]) this.buffer.clone());
            md5.digestBits = (byte[]) ((byte[]) this.digestBits.clone());
            md5.count = this.count;
            return md5;
        } catch (CloneNotSupportedException var3) {
            return md5;
        }
    }

    public static String printByteArray(byte[] b) {
        String hexString = "";

        for (int i = 0; i < b.length; ++i) {
            hexString = hexString + byte2Hex(b[i]);
        }

        return hexString;
    }

    public static String byte2Hex(byte ib) {
        char[] Digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] ob = new char[]{Digit[ib >>> 4 & 15], Digit[ib & 15]};
        String s = new String(ob);
        return s;
    }

    public static String md5(String str) {
        MD5 md5 = new MD5();
        md5.engineUpdate(str.getBytes());
        return printByteArray(md5.engineDigest()).toLowerCase();
    }
}