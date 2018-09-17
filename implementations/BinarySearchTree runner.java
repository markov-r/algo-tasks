public class Main {

    public static void main(String[] args) throws Exception {
        BinarySearchTree bt = new BinarySearchTree();

        bt.insert(10);
        bt.insert(23);
        bt.insert(21);
        bt.insert(14);
        bt.insert(18);
        bt.insert(6);
        bt.insert(18);
        bt.insert(6);
        System.out.println("===============");
        bt.traverse();
        System.out.println();
        System.out.println("===============");
        System.out.println(bt.search(6));
        bt.delete(14);
        System.out.println("===============");
        bt.traverse();

    }

}
