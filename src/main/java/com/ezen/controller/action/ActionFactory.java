package com.ezen.controller.action;

public class ActionFactory {
private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("book_update_form")) {
			action = new BookUpdateFormAction();
		} else if (command.equals("book_update")){
			action = new BookUpdateAction();
		} else if (command.equals("book_plist")){
			action = new BookPListAction();
		} else if (command.equals("book_dlist")){
			action = new BookDListAction();	
		} else if (command.equals("book_insert_form")){
			action = new BookInsertFormAction();
		} else if (command.equals("book_insert")){
			action = new BookInsertAction();
		} else if (command.equals("book_detail_view")){
			action = new BookDetailViewAction();
		} else if (command.equals("book_main")){
			action = new BookMainViewAction();
		} else if (command.equals("admin_main")){
			action = new AdminMainViewAction();
		} else if (command.equals("subscr_list")){
			action = new SubscrListAction();
		} else if (command.equals("subscr_update_form")){
			action = new SubscrUpdateFormAction();
		} else if (command.equals("subscr_update")){
			action = new SubscrUpdateAction();
		} else if (command.equals("subscr_insert_form")){
			action = new SubscrInsertFormAction();
		} else if (command.equals("subscr_insert")){
			action = new SubscrInsertAction();
		} else if (command.equals("subscr_delete")){
			action = new SubscrDeleteAction();
		}/*민우*/ else if(command.equals("login-form")) {
			action = new LibraryLoginForm();
		} else if (command.equals("join_success")) {
			action = new JoinForm();
		} else if (command.equals("idcheck")) {
			action = new IdCheckForm();
		} else if (command.equals("logincheck")) {
			action = new LoginCheck();
		} else if (command.equals("logout-form")) {
			action = new LibraryLogoutForm();
		} else if (command.equals("update_success")) {
			action = new LibraryUpdateForm();
		} else if (command.equals("passCheck")) {
			action = new PassCheckForm();
		} else if (command.equals("passUpdate")) {
		 	action = new PassUpdateForm();
		} else if (command.equals("pwupdate_success")) {
			action = new PwUpdateSuccessForm();
		} else if (command.equals("deleteCheck")) {
			action = new DeleteCheckForm();
		}
		return action;	
	}
}
