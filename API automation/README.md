## Test Plan: Categories Domain Automation

I will automate the "Categories" domain. Below is the list of proposed test cases:

### 1. Get All Categories
- **1.1** Validate the schema for "Get Categories"
- **1.2** Validate that the limit parameter is working as expected
- **1.3** Ensure the status code is `200`

### 2. Post Category
- **2.1** Post with invalid parameters, validate the error message
- **2.2** Post with valid parameters, ensure the status code is `201`

### 3. Edit Category
- **3.1** Edit the newly created category, validate the updated name
- **3.2** Ensure the status code is `200`

### 4. Get Category by ID
- **4.1** Get the updated category, verify the name matches the updated name
- **4.2** Ensure the status code is `200`

### 5. Delete Category
- **5.1** Ensure the status code is `200`

### 6. Get Category by ID (After Deletion)
- **6.1** Ensure the status code is `200`
- **6.2** Validate that the data is empty (category has been deleted)