import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex1404 extends JFrame {
	
	public Ex1404() {
		setTitle("계산기");
		setSize(300, 250);
		
		// 제목 페널
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 300, 40);
		add(titlePanel);
		JLabel title = new JLabel("계산기", JLabel.CENTER);
		title.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		titlePanel.add(title);
		
		// 숫자 페널
		JPanel numPanel = new JPanel();
		numPanel.setBounds(0, 40, 300, 40);
		// 추가
		numPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(numPanel);
		JTextField num1 = new JTextField(5);
		numPanel.add(num1);
		JTextField num2 = new JTextField(5);
		numPanel.add(num2);
		
		// 버튼 페널
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(100, 80, 100, 80); // 수정
		// 추가 (수평 간격이 10, 수직 간격이 5인 2행 2열의 GridLayout 설정)
		btnPanel.setLayout(new GridLayout(2, 2, 10, 5));
		
		add(btnPanel);
		
		JButton plus = new JButton("+");
		btnPanel.add(plus);
		
		JButton minus = new JButton("-");
		btnPanel.add(minus);
		JButton mult = new JButton("*");
		btnPanel.add(mult);
		JButton div = new JButton("/");
		btnPanel.add(div);
		
		// 결과 페널
		JPanel resPanel = new JPanel();
		resPanel.setBounds(0, 160, 300, 40);
		add(resPanel);
		JLabel lbl1 = new JLabel("결과값: ");
		resPanel.add(lbl1);
		JLabel lbl2 = new JLabel("");
		resPanel.add(lbl2);
		
		// + ActionListener 추가
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == plus) { // 더하기 버튼인지 확인
					int num01 = Integer.parseInt(num1.getText());
					int num02 = Integer.parseInt(num2.getText());
					//텍스트 필드에 입력된 숫자 얻어오기
					int result = num01 + num02;
					lbl2.setText(String.valueOf(result));
					
				}
			}
		});
		
		// - ActionListener 추가
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == minus) { // 빼기 버튼인지 확인
					int num01 = Integer.parseInt(num1.getText());
					int num02 = Integer.parseInt(num2.getText());
					//텍스트 필드에 입력된 숫자 얻어오기
					int result = num01 - num02;
					lbl2.setText(String.valueOf(result));
					
				}
			}
		});
		
		// * ActionListener 추가
		mult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mult) { // 곱하기 버튼인지 확인
					int num01 = Integer.parseInt(num1.getText());
					int num02 = Integer.parseInt(num2.getText());
					//텍스트 필드에 입력된 숫자 얻어오기
					int result = num01 * num02;
					lbl2.setText(String.valueOf(result));
					
				}
			}
		});
		
		// / ActionListener 추가
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == div) { // 나누기 버튼인지 확인
					int num01 = Integer.parseInt(num1.getText());
					int num02 = Integer.parseInt(num2.getText());
					//텍스트 필드에 입력된 숫자 얻어오기
					int result = num01 / num02;
					lbl2.setText(String.valueOf(result));
					
				}
			}
		});
		
		// 프레임 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex1404();
	}

}
