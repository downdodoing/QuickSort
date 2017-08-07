package cn;

public class QuickSort {

	public static void quickSort(int[] mList, int first, int last) {
		if (last > first) {
			int pivote = getCenterNum(mList, first, last);
			quickSort(mList, first, pivote - 1);
			quickSort(mList, pivote + 1, last);
		}
	}

	public static int getCenterNum(int[] mList, int first, int last) {
		int pivote = mList[first];
		int low = first + 1;
		int high = last;

		while (low < high) {
			while (low <= high && mList[low] <= pivote) {
				low++;
			}
			while (low <= high && mList[high] > pivote) {
				high--;
			}
			if (low < high) {
				int temp = mList[low];
				mList[low] = mList[high];
				mList[high] = temp;
			}
		}
		while (mList[high] >= pivote && high > first) {
			high--;
		}
		if (mList[high] < pivote) {
			mList[first] = mList[high];
			mList[high] = pivote;
			return high;
		} else {
			return first;
		}
	}

	public static void main(String[] args) {
		int[] mList = new int[] { 2, 5, 1, 0, 9, 8, 7, 6 };
		quickSort(mList, 0, mList.length - 1);
		for (int i = 0; i < mList.length; i++) {
			System.out.print(mList[i] + " ");
		}
	}
}
