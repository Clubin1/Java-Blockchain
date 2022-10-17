import Utils.StringUtil;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private final String data;
    private final long timeStamp;
    private int nonce;
    public Block(String data, String previousHash) {
        this.hash = calculateHash();
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
    }
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
