public class SearchRotated {

  public static void main(String[] args) {
    int[] arr = new int[args.length - 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    int target = Integer.parseInt(args[arr.length]);
    SearchRotated sr = new SearchRotated();
    System.out.println(sr.search(arr,target));
  }

  public int search(int[] arr, int target) {
    int lower = getTrueLowerBound(arr);
    int higher = lower + arr.length - 1;
    while (lower <= higher) {
      int mid = (lower + higher) / 2;
      if (arr[mid % arr.length] == target) {
        return mid % arr.length;
      } 
      if (arr[mid % arr.length] < target) {
        lower = mid + 1;
      } else {
        higher = mid - 1;
      }
    }
    return -1;
  }

  private int getTrueLowerBound(int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    int result = 0;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] > arr[r]) {
        l = mid + 1;
      } else {
        if (arr[mid] < arr[result]) {
          result = mid;
        }
        r = mid - 1;
      }
    }
    return result;
  }
}
