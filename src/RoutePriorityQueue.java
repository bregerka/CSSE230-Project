import java.util.ArrayList;

public class RoutePriorityQueue<T extends Comparable<? super T>> extends
		ArrayList<T> {

	public RoutePriorityQueue() {
	}

	@Override
	public boolean add(T element) {
		super.add(element);
		if (size() == 1)
			return true;
		int childIndex = size() - 1;
		int parentIndex = getParentIndex(childIndex);
		while (childIndex > 0) {
			if (get(childIndex).compareTo(get(parentIndex)) < 0) {
				swap(childIndex, parentIndex);
			}
			childIndex = childIndex / 2;
		}
		return true;
	}

	public int getParentIndex(int childIndex) {
		int parentIndex = (childIndex - 1) / 2;
		return parentIndex;
	}

	public boolean offer(T element2) {
		return add(element2);
	}

	public T peek() {
		if (size() == 0)
			return null;
		return get(0);
	}

	public T poll() {
		if (size() == 0)
			return null;
		T temp = peek();
		remove(temp);
		return temp;
	}

	public boolean remove(T element) {
		if (element == null)
			throw new NullPointerException();
		if (size() == 0)
			return false;
		for (int i = 0; i < size(); i++) {
			if (get(i).compareTo(element) == 0) {
				return removeHelper(i);
			}
		}
		return false;
	}

	public boolean removeHelper(int index) {
		int smallIndex = findSmallerChildIndex(index);
		if (smallIndex == -1) {
			return noChildRemove(index);
		}
		swap(index, smallIndex);
		return removeHelper(smallIndex);
	}

	private boolean noChildRemove(int index) {
		if (index == size() - 1) {
			super.remove(index);
			return true;
		}
		set(index, get(size() - 1));
		super.remove(size() - 1);
		return true;
	}

	private void swap(int index, int smallIndex) {
		T temp = get(smallIndex);
		set(smallIndex, get(index));
		set(index, temp);
	}

	public int findSmallerChildIndex(int parentIndex) {
		int secondChildIndex = (parentIndex + 1) * 2;
		int firstChildIndex = ((parentIndex + 1) * 2) - 1;
		if (firstChildIndex >= size()) {
			return -1;
		}
		if (secondChildIndex >= size()) {
			return firstChildIndex;
		}
		int compareChildren = get(firstChildIndex).compareTo(
				get(secondChildIndex));
		if (compareChildren < 0)
			return firstChildIndex;
		return secondChildIndex;
	}
}