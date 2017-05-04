package de.bijan.arraylistwannabe;

//simulated array list for type Object
public class ArrayListWannabe {

	//attributes
	private Object[] currArray;
	
	
	//constructors
	public ArrayListWannabe() {
		this.currArray = new Object[0];
	}
	public ArrayListWannabe(Object... members) {
		this.currArray = members;
	}

	
	//standard methods
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder("[");
		for(int i = 0; i < this.currArray.length; i++) {
			if(i > 0) {
				text.append(",");
			}
			text.append(this.currArray[i]); 
		}
		text.append("]");
		
		return text.toString();
	}
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof ArrayListWannabe) {
			// cast
			ArrayListWannabe that = (ArrayListWannabe) other;
			// attribute comparison
			boolean equal = false;
			int countequal = 0;
			if(this.currArray.length == that.currArray.length) {
				for(int i = 0; i < this.currArray.length; i++) {
					if(this.currArray[i] == that.currArray[i]) {
						countequal++;
					}
				}
				equal = countequal == this.currArray.length;
			}
			return 	equal;
		} else {
			return false;
		}
	}
	
	
	//features
	public Object elementAtIndex(int index) {
		return this.currArray[index];
	}
	
	public int size() {
		return this.currArray.length;
	}
	
	public void changeElement(int index, Object element) {
		if(index >= 0 && index < this.currArray.length) {
			this.currArray[index] = element;
		} else {
			System.out.println("Specified index " + index + " unusable for Array of length " + currArray.length + "!");
		}
	}
	
	public void increaseSize(int size) {
		if(this.currArray.length < size) {
			Object[] oldArray = this.currArray;
			this.currArray = new Object[size];
			
			for(int i = 0; i < oldArray.length; i++) {
				this.currArray[i] = oldArray[i];
			}
		} else if(this.currArray.length > size) {
			System.out.println("Specified size for new Array is smaller than existing Array!");
		} else {
			System.out.println("Specified size for new Array is of the same size as the old one!");
		}
	}
	
	public void add(Object element) {
		Object[] oldArray = this.currArray;
		this.currArray = new Object[oldArray.length+1];
		
		for(int i = 0; i < oldArray.length; i++) {
			this.currArray[i] = oldArray[i];
		}
		
		this.currArray[this.currArray.length-1] = element;
	}
	
	public void add(int index, Object element) {
		if(index >= 0 && index < this.currArray.length) {
			Object[] oldArray = this.currArray;
			this.currArray = new Object[oldArray.length+1];
			
			for(int i = 0; i < index; i++) {
				this.currArray[i] = oldArray[i];
			}
			
			this.currArray[index] = element;
			
			for(int i = index; i < oldArray.length; i++) {
				this.currArray[i+1] = oldArray[i];
			}
		} else {
			System.out.println("Specified index " + index + " for new element to be inserted into does not exist on Array!");
		}
	}
	
	public void remove() {
		if(this.currArray.length > 0) {
			Object[] oldArray = this.currArray;
			this.currArray = new Object[oldArray.length-1];
			for(int i = 0; i < oldArray.length-1; i++) {
				this.currArray[i] = oldArray[i];
			}
		} else {
			System.out.println("Remove operation cannot be executed on empty Array!");
		}
	}
	
	public void remove(int index) {
		if(index >= 0 && index < this.currArray.length) {
			Object[] oldArray = this.currArray;
			this.currArray = new Object[oldArray.length-1];
			
			for(int i = 0; i < index; i++) {
				this.currArray[i] = oldArray[i];
			}
			
			for(int i = index+1; i < oldArray.length; i++) {
				this.currArray[i-1] = oldArray[i];
			}
		} else {
			System.out.println("Specified index " + index + " unusable for remove Operation. (Array size: "
			+ this.currArray.length + ")!");
		}
	}
}
