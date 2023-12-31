package HuffmanTreeAlgorithm;

import HuffmanTreeAlgorithm.File.File;
import HuffmanTreeAlgorithm.File.FileD;
import HuffmanTreeAlgorithm.PriorityQueue.PriorityQueue;
import HuffmanTreeAlgorithm.Tree.Tree;

import java.io.IOException;
public class Huffman {
    private File file;
    private FileD fileD;
    private HuffmanTree huffmanTree;
    private Tree decompTree;
    private enum Type {COMPRESSION, DECOMPRESSION}
    public Huffman(String[] args) throws IOException {
        if(check(args) == Type.COMPRESSION) {
            this.file = new File(args);
            this.huffmanTree = new HuffmanTree(new PriorityQueue(file.readFileToTree()));
            this.file.codeTreeToFile(this.huffmanTree.getRoot());
            this.file.codeFile(this.huffmanTree.getDictionary());
        } else {
            this.fileD = new FileD(args);
            this.huffmanTree = new HuffmanTree(fileD.readTreeFromFile());
            this.fileD.decodefile(this.huffmanTree.getRoot());
        }

    }
    private Type check(String[] args) {
        if(args.length < 4) {
            validateFiles(args[0], args[1], args[2]);
            if(args[0].equals("-c")) {
                return Type.COMPRESSION;
            } else if(args[0].equals("-d")){
                return Type.DECOMPRESSION;
            } else {
                throw new IllegalArgumentException("First argument: Choose between (-c) compression or (-d) decompression");
            }
        } else {
            throw new IllegalArgumentException("Too much parameters added");
        }

    }
    private void validateFiles(String type, String inputURL, String outputURL) {
        if (type == null || inputURL == null || outputURL == null) {
            throw new IllegalArgumentException("Check if name of input and output files or type is added!");
        }
    }
}
