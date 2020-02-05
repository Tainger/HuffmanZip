package HuffmanCode;

import java.io.*;
import java.util.*;

public class HuffmanCode {


    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String src="F:\\Github\\HuffManZig\\Demo\\d\\xiaoji.png";
        String des="F:\\Github\\HuffManZig\\Demo\\d\\xiaoji.zip";
        String img = "F:\\Github\\HuffManZig\\Demo\\d\\2.png";
//      zipFile(src,des);
        unZipFile(des,img);


//        String content = "i like like like java do you like a java";
//        System.out.println("压缩前要传送的字节数"+content.getBytes().length);
//
//        byte []huffmanBytes = getHuffmanByteAndSetHuffmanCodes(content.getBytes());
//        System.out.println("压缩后要传送的数组"+huffmanBytes.length);
//
//        System.out.println("第一次传送的字节数");
//        System.out.println(Arrays.toString(content.getBytes()));
//        System.out.println("转化成huffmanstring");
//        byte arr[]=getHuffmanByteAndSetHuffmanCodes(content.getBytes());
//        System.out.println("压缩后传送的值");
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("解压后的huffmanString");
//        byte res[] = decode(huffmanCodes,arr);
//        System.out.println(new String(res));



//        System.out.println(Arrays.toString(content.getBytes()));

//        String content = "i like like like java do you like a java";
//        byte contentBytes[] = content.getBytes();
//        System.out.println(Arrays.toString(contentBytes));
//        List<Node> nodes = new ArrayList<>();
//        nodes = createNodes(contentBytes);
//        System.out.println("生成nodes"+nodes);
//        Node root = createHuffmanTree(nodes);
//        System.out.println("前序遍历树");
//        preOrder(root);
//        huffmanCodes=getCodes(root);
//        System.out.println("生成的HuffmanCodes"+huffmanCodes);
//        byte zipByte[] = zip(contentBytes,huffmanCodes);
//        System.out.println("HuffmanCodeBytes"+Arrays.toString(zipByte));
    }

    private static  void unZipFile(String zipFile,String unZipFile){
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        byte buffer[];
        try {
            is =new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            os = new FileOutputStream(unZipFile);
            byte huffmanBytes[] = (byte[])ois.readObject();
            huffmanCodes =(Map<Byte, String>) ois.readObject();
            buffer =decode(huffmanCodes,huffmanBytes);
            os.write(buffer);
        } catch (Exception e) {
            System.err.println("解压文件失败"+e.getMessage());
        } finally {
            try {
                ois.close();
                os.close();
                is.close();
            } catch (IOException e) {
                System.err.println("关闭文件流失败"+e.getMessage());
            }
        }
    }

    //huffmanBytes --->huffmanString
    private static byte[] decode(Map<Byte, String> huffmanCodes,byte huffmanBytes[]) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<huffmanBytes.length;i++){
            if(i ==(huffmanBytes.length-1))
               stringBuilder.append(byteToBitString(false,huffmanBytes[i]));
            else{
                stringBuilder.append(byteToBitString(true,huffmanBytes[i]));
            }
        }
        Map<String,Byte> map= new HashMap<>();
        for(Map.Entry e:huffmanCodes.entrySet()){
            map.put((String) e.getValue(),(Byte) e.getKey());
        }
        String str = new String(stringBuilder);
        List <Byte> list = new ArrayList<>();
        byte res[];
        int count=0;
        for(int i =0 ;i<str.length();){
            while((map.get(str.substring(i,i+count)))==null){
                count++;
            }
            list.add(map.get(str.substring(i,i+count)));
            i = i+count;
            count =0;
        }
        res=new byte[list.size()];
        int index=0;
        for(byte c: list){
            res[index++]=c;
        }
        return  res;

    }

    /**
     * 对一个文件进行压缩
     * @param srcFile
     * @param destFile
     */
    private static  void zipFile(String srcFile,String destFile){
        InputStream in = null;
        OutputStream os= null;
        ObjectOutputStream  oos=null;
        byte huffmanBytes[];
        try {
            os = new FileOutputStream(destFile);
            oos= new ObjectOutputStream(os);
            in = new FileInputStream(srcFile);
            byte buffer[] = new byte[in.available()];
            in.read(buffer);
            huffmanBytes=getHuffmanByteAndSetHuffmanCodes(buffer);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("压缩文件失败"+e.getMessage());
        }finally {
            try {
                in.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("压缩文件，关闭文件流失败"+e.getMessage());
            }

        }
    }

    /**
     * 将huffman生成对应的字节，转换成相应的Huffman二进制字符串
     * @param flag
     * @param b
     * @return
     */
    private static String byteToBitString(boolean flag,byte b){
        //使用变量保存b
        int temp = b; //将b转换成int
        if(flag){
            temp |= 256;  ///有些不在末尾的正数补码 在Integer.toBinaryString(temp)<8
        }
        String str = Integer.toBinaryString(temp);  //返回二进制对应的补码
        if(flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    /**
     *  根据读入字节生成Huffmancode
     *
     * @param
     * @return
     */
    private  static byte[] getHuffmanByteAndSetHuffmanCodes(byte[] b){
        List <Node> nodes=createNodes(b);
        Node huffmanTree = createHuffmanTree(nodes);
        huffmanCodes = getHuffmanCodes(huffmanTree);
        return  zip(b,huffmanCodes);
    }

    /**
     *  根据读入字节生成Huffmancode
     *
     * @param
     * @return
     */
    private  static Map<Byte,String> getBufferHuffmanCodes(byte[] b){
        List <Node> nodes=createNodes(b);
        Node huffmanTree = createHuffmanTree(nodes);
        huffmanCodes = getHuffmanCodes(huffmanTree);
       return huffmanCodes;
    }
    /**
     * 待压缩文件所对应的字节数组，然后利用Huffman编码，转换成对应1010的字符串，在按照八位重新编码
     * @param bytes  带压缩文件对应的字节数组
     * @param huffmanCodes  压缩文件对应的Huffman编码
     * @return 压缩后的字节
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        int k =0;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder);
        int len =(stringBuilder.length()+7)/8;
        byte []huffmanCodeBytes = new byte[len];
        for(int i =0;i<stringBuilder.length();i = i+8){
            if(stringBuilder.length()<i+8){
                str= stringBuilder.substring(i);
            }else {
                str=stringBuilder.substring(i,i+8);
            }
            huffmanCodeBytes[k++]=(byte) Integer.parseInt(str,2);
        }
        return huffmanCodeBytes;
    }

    /**
     * 利用重载优化代码
     */
    private static Map<Byte,String> getHuffmanCodes(Node node){
        if(node==null){
            System.out.println("空的huffman树");
        }else{
            getCodes(node.left,"0",stringBuilder);
            getCodes(node.right,"1",stringBuilder);
        }
        return huffmanCodes;
    }
    /**
     *
     * @param node
     * @param code 用于 0 / 1 左右
     * @param stringBuilder 用于保存左右路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node.data==null){
            getCodes(node.left,"0",stringBuilder1);
            getCodes(node.right,"1",stringBuilder1);
        }else{
            huffmanCodes.put(node.data,stringBuilder1.toString());
        }
    }

    /**
     * 根据节点列表生成哈夫曼树。
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {

        while(nodes.size()>1){
            Collections.sort(nodes);
            Node parent = new Node(null,nodes.get(0).weight+nodes.get(1).weight);
            parent.left = nodes.get(0);
            parent.right = nodes.get(1);
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 计算出每个字符出现的次数，次数即权值。生成节点列表
     * @param contentBytes
     * @return
     */
    private static List<Node> createNodes(byte[] contentBytes) {
        List<Node> nodes = new ArrayList<Node>();
        Map<Byte,Integer> map =new HashMap<>();
        for(byte b:contentBytes){
            if(map.containsKey(b)){
                int c = map.get(b);
                map.put(b,++c);
            }else{
                map.put(b,1);
            }
        }
        Set<Map.Entry<Byte, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Byte,Integer> entry:map.entrySet()){
            Node node = new Node(entry.getKey(),entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * 前序遍历
     * @param root
     */
    private static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("根节点为空");
        }
    }


}

class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;
    public Node(Byte data,int weight){
        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        //从小到大排列
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +"data=" + data +", weight=" + weight +"}";
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left!=null)
           this.left.preOrder();
        if(this.right!=null)
           this.right.preOrder();
    }
}
