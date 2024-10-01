package algoLessonA53FindValidParenthesisArrayString;

/*													VALID PARENTHESIS ALGORITHM IN JAVA


TASK: given a String made out of parentheses only, evaluate if the String is valid or not:
	to be valid, each parentheses has to be openend in the correct order:  ( -> ) valid     )  -->  (   NOT valid
	each parentheses has to be closed properly, using only the same type of parentheses:     () [] {} valid      [}   {] (}  NOT valid


REQUIREMENTS:

~ in order to solve the task, you're asked to create a method which uses Stack ds;

~ the method should take an input string, parse any evaluation, then in the end it should return a boolean;
	to state if the input string is valid or not;		// 	`true` means "the input string is valid"

~ don't import from java.util the Stack: create your own instead;

~~ in order for your method to check each char in the String parenthes, you either should parse the string into a
   a new Char[] array, using the String.toArray() method, or iterate the String using the .charAt() method,
		the latter requires implementation of the FOR loop which increments an `i` int variable by 1 at each step
		until you reach the end of the String 'array';

THOUGHTS:

     LOOP over each char in String, from first item to the last:
	FOR each current Char, check if IS openingParenthesis OR NOT:

	       IF YES, push() the current opening parenthesis into the stack: now the peek of the stack stores this opening parentheses;

	       IF NOT, it means is a CLOSING PARENTHESIS:

 	       		 check IF the current char IS EQUAL to ')';
	       			IF YES, check if the current ')' char IS EQUAL to peek() of the stack;
	       				if IS EQUAL, pop() the current peek from the stack: this means 'current char is valid'     // FIND a way to avoid usels next steps [ and {
	       			        if NOT EQUAL,PRINT "CURRENT STRING NOT VALID"
					and RETURN false;


	       		 check if the current char IS EQUAL to ']':
	       		 	>> DO SAME STEPS AS FOR ')';

	       		 check if the current char IS EQUAL to '}':
	       		 	>> DO SAME STEPS AS FOR ')' and ']';

	RETURN true from this method:
		you reached the end without triggering
		the return false in the for loop not even once: so it is proven
		to be a valid parenthes string;

*/

public class findValid {                    // 'file class'

	private static class Stack {           //  stack class
		private int length;
		private Node top;
		public Stack() {                   //  stack constructor
			this.length = 0;
			this.top = null;
		}

		private class Node {
			private char data;
			private Node next;
			public Node(char dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}

		public void display() {
			Node i = top;
			while(i != null) {
				System.out.print(top.data + " ->> ");
				i = i.next;
			}
			System.out.println(" null");
		}

		public boolean stackIsEmpty() {
			return length == 0;
		}

		public void push(char dataIn) {
			Node newPeek = new Node(dataIn);

			if (stackIsEmpty()) {
				top = newPeek;
			}
			else {
				newPeek.next = top;
				top = newPeek;
			}
			length++;
		}

		public char pop() {
			if(stackIsEmpty()) {
				return 'x';
			}
			char poppedChar = top.data;
			top = top.next;
			length--;
			return poppedChar;
		}

		public char peek() {
			return top.data;
		}

/*
	le parentesi sono composte da due elementi, un apertura e una chiusura;   {}
	
	ogni parentesi, una volta aperta, va chiusa;       ( --> )
	se 'apri' una parentesi usando una chiusura, questo e' un errore;   ][
	tutte le parentesi aperte vanno chiuse:       (([[]][()]))
	non puoi mettere una apertura isolata dentro una parentesi chiusa:  ([)


   itera dal primo element nell'array fino all'ultimo:

        (fai un controllo se l'elemento e' valido)
           
        trovi una parentesi aperta
              mettila nella stack e vai al prossimo elemento se presente

        trovi una parentesi chiusa 
              controlla se la stack e' vuota:
              se la stack e' vuota, non ci soeno parentesi aperte da confrontare, quindi questa parentesi e' spaiata: errore

              se la stack non e' vuota, l'elemento corrente (la chiusura) deve combaciare con il peek della stack (che deve essere un apertura)              
                                        va bene se:   ) combacia con peek (   o ] con peek [   infine   } con peek {;

                                        se non combacia: l'elemento corrente e' una chiusura senza apertura         ((( ] ))){[[]]}

  	fine loop: se la stack non e' vuota significa che ci sono aperture non chiuse       ((([]{{}})   ..)) ???

*/
		
		
		public boolean charIsOpeningParenthesis(char current) {
			if (current == '(' || current == '[' || current =='{') {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean charIsClosingParenthesis(char current) {
			if (current == ')' || current == ']' || current == '}') {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean notParenthesis(char current) {
			if ( current != '(' || current != ')' || current != '[' || current != ']' || current != '{' || current != '}' ) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isValidString(String inputString) {
			char[] input = inputString.toCharArray();

			for (int i = 0; i < input.length; i++) {
				char currentChar = input[i];

				if(charIsOpeningParenthesis(currentChar)) {
					push(currentChar);
				}
				else if (charIsClosingParenthesis(currentChar) && !stackIsEmpty()) {
					if (
						( peek() == '(' && currentChar == ')' ) ||
						( peek() == '[' && currentChar == ']' ) ||
						( peek() == '{' && currentChar == '}' )
					) {
						pop();
					}
					else {
						return false;
					}
				}
				else if (charIsClosingParenthesis(currentChar) && stackIsEmpty()) {
					return false;
				}
				else if (notParenthesis(currentChar)) {
					System.out.println("ERROR, invalid input found at position: " + i + ". char found: " + currentChar);
					return false;
				}
			}
			return true;
		}
		

	}
	
	
	public static void main(String[] args) {

	String inputNotValid = "()(())[][[]]{{}}{}({}))()";   // the error is the third from last closing parenthesis;
	String inputValid = "()()[][]{}{}(({{}}))";
	String inputNotValidChar = "()()[][]{}{}(({{s}}))";

	Stack charStack = new Stack();

        System.out.println(charStack.isValidString(inputValid));
        System.out.println(charStack.isValidString(inputNotValid));
        System.out.println(charStack.isValidString(inputNotValidChar));
	}

}
