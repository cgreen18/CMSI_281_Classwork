//package tree.binary;

  public class BinaryTreeNode {

      private String data;
      private BinaryTreeNode left, right;

      BinaryTreeNode (String s) {
          data = s;
          left = null;
          right = null;
      }

      public void add (String s, String child) {
          if (child.equals("L")) {
              left = new BinaryTreeNode(s);
          } else if (child.equals("R")) {
              right = new BinaryTreeNode(s);
          } else {
              throw new IllegalArgumentException();
          }
      }

      public BinaryTreeNode getChild (String child) {
          return (child.equals("L")) ? left : right;
      }

      public String getString () {
          return data;
      }

      public void doubleTree () {
          BinaryTreeNode doubNode = new BinaryTreeNode(data);

          if(left != null){
              left.doubleTree();
          }

          doubNode.left = left;
          left = doubNode;


          if(right != null){
              right.doubleTree();
          }

      }

      public static boolean sameTree (BinaryTreeNode n1, BinaryTreeNode n2) {
          if(n1 == null && n2 == null){
              return true;
          }
          else if(n1 == null){
              return false;
          }
          else if(n2 == null){
              return false;
          }
          else if(!n1.data.equals(n2.data)){
              return false;
          }

          if(!sameTree(n1.left,n2.left)){
              return false;
          }
          if(!sameTree(n1.right,n2.right)){
              return false;
          }

          return true;
      }

      public static void printInorder(BinaryTreeNode n)
      {
          if (n == null) {return;}
          printInorder(n.left);
          System.out.print(n.data + " ");
          printInorder(n.right);
      }

      public static void preOrderPrint (BinaryTreeNode n) {
          if (n == null) {return;}
          System.out.print(n.data + " ");
          preOrderPrint(n.left);
          preOrderPrint(n.right);
      }

      public static void main(String[] args){
          BinaryTreeNode root = new BinaryTreeNode("2");
          root.add("1", "L");
          root.add("6", "R");
          BinaryTreeNode lefty = root.getChild("L");
          lefty.add("3", "L");
          lefty.add("4", "R");
          lefty = root.getChild("R");
          lefty.add("5", "L");
          preOrderPrint(root);



          System.out.println("");

          BinaryTreeNode rootie = new BinaryTreeNode("2");
          rootie.add("1", "L");
          rootie.add("6", "R");
          BinaryTreeNode leftie = rootie.getChild("L");
          leftie.add("4", "L");
          leftie.add("3", "R");
          leftie = rootie.getChild("R");
          leftie.add("5", "L");
          preOrderPrint(rootie);

          System.out.println("");
          System.out.println(sameTree(root,rootie));


          root.doubleTree();
          preOrderPrint(root);
          System.out.println("");
          preOrderPrint(rootie);
          System.out.println("");
          System.out.println(sameTree(root,rootie));
          System.out.println("");

          rootie.doubleTree();
          preOrderPrint(root);
          System.out.println("");
          preOrderPrint(rootie);
          System.out.println("");
          System.out.println(sameTree(root,rootie));

          BinaryTreeNode secondie = leftie.getChild("L");
          secondie.add("9", "L");
          preOrderPrint(root);
          System.out.println("");
          preOrderPrint(rootie);
          System.out.println("");
          System.out.println(sameTree(root,rootie));


          System.out.println("");
      }


  }
