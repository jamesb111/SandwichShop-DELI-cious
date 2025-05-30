## 🥪 SandwichShop-DELI-cious

Welcome to the DELI-cious sandwich shop. This Java application simulates a food ordering system enabling users to build and customize sandwich orders, add chips add drinks, and generates a receipt txt file . It is a console-based program that demonstrates object-oriented programming principles, menu navigation, and user interaction.

## 📂 Project Structure

| File               | Description |
|--------------------|-------------|
| `App.java`         | Main entry point of the application. |
| `UserInterface.java` | Handles user interaction via console input/output. |
| `Order.java`       | Represents a customer’s complete order. |
| `Sandwich.java`    | Represents a sandwich and its customizable components. |
| `Topping.java`     | Defines sandwich toppings and their costs. |
| `Chips.java`       | Represents a chips selection. |
| `Drink.java`       | Represents a drink selection and its size. |
| `ItemSize.java`    | Enum for size options (e.g., SMALL, MEDIUM, LARGE). |
| `ReceiptWriter.java` | Handles receipt formatting and output. |
| `MenuArrays.java`  | Contains menu data arrays used throughout the application. |

## ✅ Features

- New Order Creation: Start a new order from the main menu.
  - <img width="500" alt="Image" src="https://github.com/user-attachments/assets/c8c6afeb-7b19-49f1-90a9-30ffc210ac49" />
- Sandwich Customization:
  - Choose sandwich size (Small, Medium, Large).
    - <img width="755" alt="Image" src="https://github.com/user-attachments/assets/e96dbe0a-7419-48a5-af1f-44794cb2b950" />
  - Select bread type (White, Wheat, Rye, Wrap).
    - <img width="513" alt="Image" src="https://github.com/user-attachments/assets/0dc3bd3c-a707-4495-9aa9-c1e569bd47cd" />
  - Option to toast the bread.
    - <img width="354" alt="Image" src="https://github.com/user-attachments/assets/e92e7ef4-d6c5-4603-bef5-a810b1b73aba" />
  - Add various toppings, including meats, cheeses, regular toppings, and sauces.
    - <img width="500" alt="Image" src="https://github.com/user-attachments/assets/f2d665fb-c0be-49fd-8a3e-3348c966c8f3" />
  - Option to add "extra" portions of meats and cheeses for an additional cost.
    - <img width="770" alt="Image" src="https://github.com/user-attachments/assets/02a56b07-201b-4394-afd7-f63fb657e1fb" />
- Drink Selection: Choose from a variety of drinks and select their size (Small, Medium, Large).
  - <img width="500" alt="Image" src="https://github.com/user-attachments/assets/34e0daaa-b755-4bae-9ca5-8e3422d53a81" />
- Chip Selection: Select from a list of available chip types.
  - <img width="500" alt="Image" src="https://github.com/user-attachments/assets/da5ab292-271e-43c7-994e-3b1bc95abf70" />
- Order Summary & Calculation: View a detailed breakdown of all items in the current order, including prices with the total cost of the order.
  - <img width="530" alt="Image" src="https://github.com/user-attachments/assets/9b1b5052-70f3-4a7c-999a-fd9dd69fb6a8" />
- Receipt Generation: Save the order receipt to a text file with a timestamped filename.
  - <img width="548" alt="Image" src="https://github.com/user-attachments/assets/913803cc-12c5-4cb2-b0e3-0eaed69642a4" />


## Interesting piece of code
- MenuArrays class: Used to check if user selections actually match items on our menu. I find this most interesting because it makes my conditionals for deciding if an item should be added as topping or not qutie easy.
  - <img width="946" alt="Image" src="https://github.com/user-attachments/assets/7a058be4-be0c-42c6-9474-51030b16877e" />
