package com.project.AdminModule;

public interface SweetDao { // interface whose functionality is just declared

	public void manage(SweetPojo obj); // Admin manages the sweet shop

	public void showcatalogue(int categoryid); // displays sweetnames with particular category id

	public void showproducts(); // displays brand names(manufacturers)

	public void deletesweet(int orderid); // deletes the sweets w.r.t to

	public void showAllorders(); // admin takes a look at at all orders

}
