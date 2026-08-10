class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new ArrayDeque<>();
        ArrayList<String> op = new ArrayList<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");

        for(int i = 0; i < tokens.length; i++){
            //first check if next is operator
            //if it is then pop off the 2
            //if not then push it onto the stack
            //System.out.println(st.peek());
            if(op.contains(tokens[i])){
                int tempOp = 0;
                String p1 = st.pop();
                String p2 = st.pop();
                if(tokens[i].equals("+")){
                    tempOp = Integer.parseInt(p2) + Integer.parseInt(p1);
                    //st.push(String.valueOf(tempOp)); --> stiupid dumabsas lidne of code 
                }else if(tokens[i].equals("-")){
                    tempOp = Integer.parseInt(p2) - Integer.parseInt(p1);
                }else if(tokens[i].equals("*")){
                    tempOp = Integer.parseInt(p2) * Integer.parseInt(p1);
                }else if(tokens[i].equals("/")){
                    tempOp = Integer.parseInt(p2) / Integer.parseInt(p1);
                }
                
                st.push(String.valueOf(tempOp));
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.peek());
    }    
}
/*
v3
tokens=["3","11","5","+","-"]
st: 3 11 5 
p1 = 5
p2 = 11
tempOp = 16
st: 3 16
-
p1 = 16
p2 = 3
tempOp = -13



+



*/

/*
v2


Input: tokens = ["1","2","+","3","*","4","-"]

thinking is you only pop off the 2 vals before the operator

push vals onto stack if not operator

- note easy to id the operators cause its only + - * and /

st: 1 2

see operator (+)

pop off 2 prev & do operator
1 + 2 = 3

push back on? - yes

st: 3

st: 3 3

see operator (*)

pop off 2 prev & *

3 * 3 = 9

st: 9 4

see operator (-)

9 - 4 = 5
st: 5
when done with loop end
the last value on your stack is what you return



*/

/*


v1


Input: tokens = ["1","2","+","3","*","4","-"]

sum = 0

st: 1 2 
see operator
or do you pop until your stack is empty & keep doing the operation to the total sum
1 + 2 = 3
3 + 0

keep track as sum
sum = 3

st: n/a
st: 3

see * operator

sum *= 3 = 9

push next val
st: 4

see - operator

do the operator --> 

sum -=4  = 5

-------

v2


Input: tokens = ["1","2","+","3","*","4","-"]

thinking is you only pop off the 2 vals before the operator

push vals onto stack if not operator

- note easy to id the operators cause its only + - * and /

st: 1 2

see operator (+)

pop off 2 prev & do operator
1 + 2 = 3

push back on? - yes

st: 3

st: 3 3

see operator (*)

pop off 2 prev & *

3 * 3 = 9

st: 9 4

see operator (-)

9 - 4 = 5
st: 5
when done with loop end
the last value on your stack is what you return




*/