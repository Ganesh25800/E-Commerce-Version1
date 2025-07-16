################################################################################################################################################

🛒 Java E-Commerce Console Application

This is a full-featured **console-based e-commerce system** built using Java, JDBC, and H2 embedded SQL database. 
It simulates a real online shopping experience through a terminal interface — including user login, product browsing, cart management, order placement, and profile updates.

---

## 📁 Project Structure

		E-Commers/
		├── src/ # All Java source code
		├── data/ # CSV files for categories, subproducts, newproduct.
		├── lib/ # H2 database JAR
		├── .gitignore
		├── README.md


---

## 🚀 Features

- ✅ **User Signup & Login**
- 🛍️ **Browse Products** by Category & Subcategory
- 🛒 **Add to Cart**, View Cart & Place Orders
- 📦 **Order History** (with delete option)
- 👤 **Profile Update** (name, email, password, user ID)
- 💾 **H2 Embedded Database** auto-created at runtime
- 🔒 **Session Management** using `SessionManager`

---

## 🧪 Technologies Used

- Java (OOP, Collections)
- JDBC (Database Connectivity)
- H2 Database (embedded `.mv.db` file)
- CSV File Parsing (`BufferedReader`)

---

## 🧰 How to Run

> 💡 Requires **Java 8 or Higher**

---
### Clone the Repo

   ```bash
   git clone https://github.com/your-username/E-Commers.git
   
   
### ✅ Step 1: Setup After Cloning

*** The folder and files structure should be Exact as shown in below structure.

		E-Commers/
		├── data/
		│   ├── category.csv
		│   ├── newproduct.csv
		│   ├── subproduct.csv
		├── lib/
		│   └── h2-2.3.232.jar
		└── src/
			├── DatabaseConnection/
			│   ├── H2DatabaseConnection.java
			├── ProductShopping/
			│   ├── AddToCart.java
			│   ├── ProductConfirmation.java
			│   ├── ProductDataLoader.java
			│   ├── ProductShopingProduct.java
			│   ├── ProductShopingSubProductPage.java
			│   ├── ProductShoppingCategory.java
			├── FileClasses/
			│   ├── ProductClass.java
			│   ├── SubProductClass.java
			├── UpdateProfile/
			│   ├── CheckingNewUserEmailInDatabase.java
			│   ├── ConfirmUserNewAccount.java
			│   ├── DeleteUserProfile.java
			│   ├── DeleteUserProfileConfirmation.java
			│   ├── DisplayProfile.java
			│   ├── UpdateProfileDisplay.java
			│   ├── UpdateUserEmail.java
			│   ├── UpdateUserFirstOrLastName.java
			│   ├── UpdateUserId.java
			│   ├── UpdateUserPassword.java
			├── ViewCart/
			│   ├── ConfirmCartProducts.java
			│   ├── EmptyCartAfterPlacingOrder.java
			│   ├── PlaceTheOrder.java
			│   ├── UserCartProduct.java
			├── ViewOrder/
			│   ├── DeleteOrderHistory.java
			│   ├── GetUserOrdersFromDatabase.java
			│   ├── ViewOrderCategory.java
			│   ├── ViewPlacedOrders.java
			├── Other Java Files:
			├── ECommerceHome.java
			├── LoadUserDetailsAfterUpdate.java
			├── ProjectFlowDisplay.java
			├── SessionManager.java
			├── User.java
			├── UserHomePage.java
			├── UserLogin.java
			├── UserSignup.java


### ✅ Step 2: Running the Application (Based on IDE)

	🟢 VS Code (Recommended)
	
		*** ✅ No additional setup is required.

		*** Simply open the E-Commers/ folder in VS Code.

		*** Open ECommerceHome.java from the src/ folder.

		*** Right-click and choose Run Java (make sure the Java Extension Pack is installed).

		*** The H2 database JAR in the lib/ folder will work automatically if you're using the VS Code classpath configuration.
		
		
	🟡 IntelliJ IDEA

		*** Open the E-Commers/ folder as a project in IntelliJ.

		*** Navigate to: File > Project Structure > Modules > Dependencies.

		*** Click + → JARs or directories.

		*** Select the JAR file: lib/h2-2.3.232.jar and click OK.

		*** Apply the changes.

		*** Open src/ECommerceHome.java, right-click, and select Run.
		
		
	🔵 Eclipse

		*** Open Eclipse and select: File > Import > Existing Projects into Workspace.

		*** Choose the E-Commers/ directory.

		*** Right-click the project → Build Path > Configure Build Path.

		*** Go to the Libraries tab → click Add External JARs.

		*** Select: lib/h2-2.3.232.jar and apply changes.

		*** Navigate to ECommerceHome.java, right-click → Run As > Java Application.
		
		