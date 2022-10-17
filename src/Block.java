import Utils.StringUtil;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private final String data;
    private final long timeStamp;

    public Block(String data, String previousHash) {
        this.hash = calculateHash();
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }

    public String calculateHash() {
        return StringUtil.applySha256(previousHash + Long.toString(timeStamp) + data);
    }
}