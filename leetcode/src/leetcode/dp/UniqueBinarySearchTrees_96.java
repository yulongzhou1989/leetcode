package leetcode.dp;

public class UniqueBinarySearchTrees_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//1. ∑1,n f(i, n) = G(n) G(n):unique BSF for n F(i,n): unique BSF for when i root (sum all cases together with each one can be a node)

	//2. f(i, n) = G(i-1) * G(n-i);  eg :[1,2,3,4,5,6,7] take 3 root-> [1,2]->G(2), [4,5,6,7]->G(4)

	//Join 1&2 G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ....+G(n-1)*G(0)
	
	public int numTrees(int n) {
        int [] G = new int [n+1];
		G[0] = G[1] = 1;
		
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				G[i] += G[j-1]*G[i-j];
			}
		}
		
		return G[n];
    }

}
