package PROJE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;

public class proje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_kullaniciadi;
	private JTextField txt_sifre;


	private String ad = "Ertuğrul Bağdat";
	private String sif = "1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proje frame = new proje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public proje() {
		setTitle("Giris ekranı");
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));

		setContentPane(contentPane);

		JLabel lbl_kullanıcıad = new JLabel("Yönetici adı :");
		lbl_kullanıcıad.setForeground(new Color(0, 0, 0));
		lbl_kullanıcıad.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lbl_sifre = new JLabel("Şifre :");
		lbl_sifre.setForeground(new Color(0, 0, 0));
		lbl_sifre.setFont(new Font("Tahoma", Font.BOLD, 17));

		JButton btn_giris = new JButton("Giris");
		btn_giris.setFont(new Font("Stencil", Font.BOLD, 20));
		btn_giris.setForeground(new Color(0, 0, 0));
		btn_giris.addActionListener(e -> authenticateUser());

		txt_kullaniciadi = new JTextField();
		txt_kullaniciadi.setColumns(10);

		txt_sifre = new JTextField();
		txt_sifre.setColumns(10);

		JLabel lbl_kullanıcıad_1 = new JLabel("YÖNETİM GİRİŞ EKRANI");
		lbl_kullanıcıad_1.setForeground(new Color(0, 0, 0));
		lbl_kullanıcıad_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(80)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lbl_kullanıcıad_1)
								.addComponent(btn_giris)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lbl_kullanıcıad).addComponent(lbl_sifre))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txt_kullaniciadi, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_sifre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(394, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19).addComponent(lbl_kullanıcıad_1).addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lbl_kullanıcıad)
								.addComponent(txt_kullaniciadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_sifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_sifre))
						.addGap(34).addComponent(btn_giris).addContainerGap(76, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		/*
		 * EĞER DOĞRU İSE contentPane.setLayout(gl_contentPane);
		 * 
		 * }); btn_giris.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // İkinci pencereyi oluştur otopark
		 * secondWindow = new otopark(); secondWindow.setVisible(true); // İkinci
		 * pencereyi aç }
		 */
	}

	private void authenticateUser() { // giriş butonuna tıklandığında bu method çalışıypr
		String username = txt_kullaniciadi.getText(); // kullanıcı adı içine yazılan stringi gettext() methodu ile
														// alıyoruz
		String password = txt_sifre.getText(); // sifre içine yazılan stringi gettext() methodu ile alıyoruz

		if (username.equals(ad) && password.equals(sif)) {
			// Eğer giriş başarılıysa ikinci ekrana geçiş yap
			JOptionPane.showMessageDialog(this, "Giris yapıldı"); // ekrana bilgi veriyoruz
			Veritablosu veritablosu = new Veritablosu();
			veritablosu.setVisible(true);
			this.setVisible(false); // İlk ekranı kapat
		} else {
			JOptionPane.showMessageDialog(null, "Geçersiz kullanıcı adı veya şifre.", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}