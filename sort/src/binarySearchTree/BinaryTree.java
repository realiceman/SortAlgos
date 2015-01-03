package binarySearchTree;

public class BinaryTree {
	
	Node root;
	
	public void add(int data){
		Node nodeToAdd = new Node(data);
		
		if(root == null){
			root = nodeToAdd;
		}
		
		traverseAndAddNode(root, nodeToAdd);
		
	}

	private void traverseAndAddNode(Node node, Node nodeToAdd) {
		
		if(nodeToAdd.data < node.data){
			if(node.leftchild==null){
				nodeToAdd.parent = node;
				node.leftchild= nodeToAdd;
			}
			else{
			traverseAndAddNode(node.leftchild, nodeToAdd);
			}
		}
		else if(nodeToAdd.data > node.data){
			if(node.rightchild==null){
				nodeToAdd.parent = node;
				node.rightchild= nodeToAdd;
			}
			else{
			traverseAndAddNode(node.rightchild, nodeToAdd);
			}
		}
	}
	
	public void traverse(){
		if(root!=null){
			Node nodeToTraverse = root;
			if(nodeToTraverse.leftchild==null && nodeToTraverse.rightchild==null){
				System.out.println(nodeToTraverse.data);
			}
			else{
				if(nodeToTraverse.leftchild!=null){
					infixeTraverse(nodeToTraverse.leftchild);
				}
				if(nodeToTraverse.rightchild!=null){
					infixeTraverse(nodeToTraverse.rightchild);
				}
			}
		}
	}
	
	public void infixeTraverse(Node node){
		
			if(node.leftchild!=null){
				infixeTraverse(node.leftchild);
			}
			System.out.println(node.data);
			
			
			if(node.rightchild!=null){
				infixeTraverse(node.rightchild);
			}
		}
	
/*
	public void prefixeTraverse(Node node){
	  
	  System.out.println(node.data);
		
		if(node.leftchild!=null){
			prefixeTraverse(node.leftchild);
		}
		
		if(node.rightchild!=null){
			prefixeTraverse(node.rightchild);
		}
	}
	
	
	
	public void postfixeTraverse(Node node){
	  
		
		if(node.leftchild!=null){
			postfixeTraverse(node.leftchild);
		}
		
		if(node.rightchild!=null){
			postfixeTraverse(node.rightchild);
		}
		
		 System.out.println(node.data);
	}
	*/
	
	public boolean delete(int val){
		//cas 1 : node n'a pas d'enfants
		//cas 2 : node a un enfant
		//cas 3 : node a deux enfants
		Node nodeToBeDeleted = find(val);
		if(nodeToBeDeleted != null){
			
			if(nodeToBeDeleted.leftchild==null && nodeToBeDeleted.rightchild==null){
				deleteCase1(nodeToBeDeleted);
			}
			else if(nodeToBeDeleted.leftchild!=null && nodeToBeDeleted.rightchild!=null){
				deleteCase3(nodeToBeDeleted);
			}
			else if(nodeToBeDeleted.leftchild!=null){
				   //cas2 : on elimine l'enfant gauche
				deleteCase2(nodeToBeDeleted);
			}
			else if(nodeToBeDeleted.rightchild!=null){
				   //cas2 : on elimine l'enfant droit
				deleteCase2(nodeToBeDeleted);
			}
		}
		return false;
	}
	
	
	
	private void deleteCase1(Node nodeToBeDeleted){
		if(nodeToBeDeleted.parent.leftchild==nodeToBeDeleted){
			 nodeToBeDeleted.parent.leftchild=null;
		}else if(nodeToBeDeleted.parent.rightchild==nodeToBeDeleted){
			nodeToBeDeleted.parent.rightchild=null;
		}
	}
	
	
	private void deleteCase2(Node nodeToBeDeleted){
		if(nodeToBeDeleted.parent.leftchild==nodeToBeDeleted){
			if(nodeToBeDeleted.leftchild!=null){
			nodeToBeDeleted.parent.leftchild = nodeToBeDeleted.leftchild;
			}else if(nodeToBeDeleted.rightchild!=null){
			nodeToBeDeleted.parent.leftchild = nodeToBeDeleted.rightchild;
			}
		}
		else if(nodeToBeDeleted.parent.rightchild==nodeToBeDeleted){
			if(nodeToBeDeleted.leftchild!=null){
				nodeToBeDeleted.parent.rightchild = nodeToBeDeleted.leftchild;
				}else if(nodeToBeDeleted.rightchild!=null){
				nodeToBeDeleted.parent.rightchild = nodeToBeDeleted.rightchild;
				}
		}
	}
	
	private void deleteCase3(Node nodeToBeDeleted){
		Node minNode = minLeftTraversal(nodeToBeDeleted.rightchild);
		deleteCase2(minNode);
		
		minNode.parent = nodeToBeDeleted.parent;
		minNode.leftchild = nodeToBeDeleted.leftchild;
		minNode.rightchild = nodeToBeDeleted.rightchild;
		
		nodeToBeDeleted.parent.rightchild = minNode;
		
		if(nodeToBeDeleted.parent.leftchild == nodeToBeDeleted){
			nodeToBeDeleted.parent.leftchild = minNode;
			
		}else if (nodeToBeDeleted.parent.rightchild == nodeToBeDeleted){
			nodeToBeDeleted.parent.rightchild = minNode;
		}
	}
	
	
	
	private Node minLeftTraversal(Node node){
		if((node.leftchild)==null){
			return node;
		}
		return minLeftTraversal(node.leftchild);
	}
	
	
	public Node find (int val){	
		if(root!=null){
			return findNode(root, new Node(val));
		}
		return null;
	}
	
	
	
	private Node findNode(Node search, Node node){
		if(search==null)return null;
		
		if(search.data == node.data){
			return search;
		}
		else{
			Node returnNode = findNode(search.leftchild, node);
			
		   if(returnNode==null){
			   returnNode = findNode(search.rightchild,node);
		   }
		   return returnNode;
		
		}
		
	}
	
	
	
	
}
