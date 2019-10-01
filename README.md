# GoJEK Car Parking 
 **Version 1 . 4 . 2**

## Project Intro

Create parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one. I want to create an automated ticketing system that allows my customers to use my parking lot without human intervention. 
Due to government regulation, the system should provide me with the ability to find 
out: 
- Registration numbers of all cars of a particular color. 
- Slot number in which a car with a given registration number is parked. 
- Slot numbers of all slots where a car of a particular color is parked.

 
## Flow chart:

```mermaid
graph LR
A[App] -- Create --> B((Parking Lot))
B --> C(Park Car)
C--> D{Check Free Space}
D --> E(Yes)
E-->L[Block Free Slot]
L-->O
D--> F(No)
B-->G(Leave Car)
G-->H{Find Car}
H --> I(Yes)
H--> J(No)
J-->O(Output Message)
O-->B
I-->K[Free The Slot]
K-->O
F-->O
O-->M((End))

