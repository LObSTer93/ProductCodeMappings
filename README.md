# Backend Developer Task

## SKU, Version, Quantity - Coding Task

Write a method that takes two inputs: a list of purchased product codes and a map of
mappings for these codes. The method should return an aggregated list of purchased
products and quantity based on the list of purchased products codes.

**Inputs**


List of products: ["CVCD", "SDFD", "DDDF", "SDFD"]
Mappings: {"CVCD": {"version": 1,"edition": "X"},"SDFD": {"version": 2,"edition":"Z"},"DDDF": {"version": 1}}

**Expected Output**


Purchased items:
[{"version":1,"edition":"X","quantity":1},{"version":1,"quantity":1},{"version":2,"edition":"Z","quantity":2}
