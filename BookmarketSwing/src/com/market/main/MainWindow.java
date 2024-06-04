package com.market.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.market.cart.Cart;
import com.market.bookitem.BookInIt;
import com.market.page.CartAddItemPage;
import com.market.page.CartItemListPage;
import com.market.page.CartShippingPage;
import com.market.page.AdminLoginDialog;
import com.market.page.AdminPage;


public class MainWindow extends JFrame {
	static Cart mCart;
	static JPanel mMenuPanel, mPagePanel;
	
	public MainWindow(String title, int x, int y, int width, int height) {
		
		initContainer(title, x, y, width, height);
		
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
	}
	
	private void initContainer(String title, int x, int y, int width, int height) {
		setTitle(title);
		setBounds(x, y, width, height);
		setLayout(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation((screenSize.width - 1000) /2, (screenSize.height - 750) /2);
		mMenuPanel = new JPanel();
		mMenuPanel.setBounds(0, 20, width, 130);
		menuIntroduction();
		add(mMenuPanel);
		
		mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, width, height);
		add(mPagePanel);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(false);
				new GuestWindow("고객 정보 입력", 0, 0, 1000, 750);
			}
		});
	}
	
	private void menuIntroduction() {
		mCart = new Cart();
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		JButton bt1 = new JButton("고객 정보 확인하기", 
				new ImageIcon("./image/1.png"));
		bt1.setBounds(0, 0, 100, 50);
		bt1.setFont(ft);
		mMenuPanel.add(bt1);
		
		JButton bt2 = new JButton("장바구니 상품 목록 보기", 
				new ImageIcon("./image/2.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt2);
		
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (mCart.mCartCount == 0)
					JOptionPane.showMessageDialog(bt2, "장바구니에 항목이 없습니다", "장바구니 상품 목록 보기", 
					JOptionPane.ERROR_MESSAGE);
				else {
					mPagePanel.removeAll();
					mPagePanel.add("장바구니 상품 목록 보기", new CartItemListPage(mPagePanel, mCart));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		
		JButton bt3 = new JButton("장바구니 비우기", 
				new ImageIcon("./image/3.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt3);
		
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mCart.mCartCount == 0)
					JOptionPane.showMessageDialog(bt3, "장바구니에 항목이 없습니다", "장바구니 비우기",
							 JOptionPane.ERROR_MESSAGE);
				else {
				mPagePanel.removeAll();
				menuCartClear(bt3);
				mPagePanel.add("장바구니에 항목 추가하기", new CartAddItemPage(mPagePanel,mCart));
				mPagePanel.revalidate();
				mPagePanel.repaint();
				}
			}
		});
	}
	
		private void menuCartClear (JButton button) {
			
			if(mCart.mCartCount == 0)
				JOptionPane.showMessageDialog(button, "장바구니에 항목이 없습니다");
			else {
				int (select == 0) {
					mCart.deleteBook();
					JOptionPane.showMessageDialog(button, "장바구니의 모든 항목을 삭제했습니다.");
				}
			}
		}
}
		
		JButton bt4 = new JButton("장바구니에 항목 추가하기", 
				new ImageIcon("./image/4.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt4);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mPagePanel.removeAll();
				BookInIt.init();
				mPagePanel.add("장바구니에 항목 추가하기", new CartAddItemPage(mPagePanel,mCart));
				mPagePanel.revalidate();
				mPagePanel.repaint();
			}
		});
		
		JButton bt5 = new JButton("장바구니의 항목 수량 줄이기", 
				new ImageIcon("./image/5.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt5);
		
		JButton bt6 = new JButton("장바구니의 항목 삭제하기", 
				new ImageIcon("./image/6.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt6);
		
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (mCart.mCartCount == 0)
					JOptionPane.showMessageDialog(bt3, "장바구니에 항목이 없습니다.", "장바구니 비우기", 
							JOptionPane.ERROR_MESSAGE);
				else {
					
					mPagePanel.removeAll();
					CartItemListPage cartList = new CartItemListPage(mPagePanel, mCart);
				if (mCart.mCartCount == 0)
					JOptionPane.showMessageDialog(bt6, "장바구니에 항목이 없습니다");
				else if (cartList.mSelectRow == -1)
					JOptionPane.showMessageDialog(bt6, "장바구니에서 삭제할 항목을 선택하세요");
				else {
					mCart.removeCart(cartList.mSelectRow);
					// 장바구니에서 선택 항목 삭제하기
					cartList.mSelectRow = -1;
				}
			}
			mPagePanel.add("장바구니의 항목 삭제하기", new CartItemListPage(mPagePanel, mCart));	
		
			mPagePanel.revalidate();
			mPagePanel.repaint();
			}
		});
			
		JButton bt7 = new JButton("주문하기", 
				new ImageIcon("./image/7.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt7);
		
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (mCart.mCartCount == 0)
					JOptionPane.showMessageDialog(bt7, "장바구니에 항목이 없습니다", "주문처리", 
							JOptionPane.ERROR_MESSAGE);
				else {
					
					mPagePanel.removeAll();
					mPagePanel.add("주문 배송지", new CartShippingPage(mPagePanel, mCart));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		
		JButton bt8 = new JButton("종료", 
				new ImageIcon("./image/8.png"));
		bt1.setBounds(0, 0, 100, 30);
		bt1.setFont(ft);
		mMenuPanel.add(bt8);
		
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select = JOptionPane.showConfirmDialog(bt8, "쇼핑몰을 종료하겠습니까?");
				
				if (select == 0) {
					System.exit(1);
				}
			}
		});
		
		JButton bt9 = new JButton("관리자", 
				new ImageIcon("./image/9.png"));
		bt9.setFont(ft);
		mMenuPanel.add(bt9);
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
			AdminLoginDialog adminDialog;
			JFrame frame = new JFrame();
			adminDialog = new AdminLoginDialog(frame, "관리자 로그인");
			adminDialog.setVisible(true);
			if (adminDialog.isLogin) {
			mPagePanel.removeAll();
			mPagePanel.add("관리자", new AdminPage(mPagePanel));
			mPagePanel.revalidate();
			mPagePanel.repaint();
			}
		  }
		});
	
	public static void main(String[] args) {
		new MainWindow("도서 쇼핑몰", 0, 0, 1000, 750);
	}
}
