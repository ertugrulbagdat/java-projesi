package PROJE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Veritablosu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final String url = "jdbc:sqlserver://Ertugrul:1433;databaseName=veritabani;encrypt=true;trustServerCertificate=true";
	private static final String user = "sa";
	private static final String sifre = "1234";
	private JTable tablo;
	private JTextField textad;
	private JTextField textsoyad;
	private JTextField textarama;
	private JTextField textdepartman;
	private JTextField textmaas;
	private JScrollPane scrollPane;
	private JButton butonara;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Veritablosu frame = new Veritablosu();
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
	public Veritablosu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Çalışan Adı:\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel_1 = new JLabel("Çalışan Soyadı:\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textad = new JTextField();
		textad.setColumns(10);

		textsoyad = new JTextField();
		textsoyad.setColumns(10);

		JButton butonekle = new JButton("Yeni Çalışan Ekle");
		butonekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calisanekle();
				tabloyenile();
			}
		});

		JButton butonguncelle = new JButton("Çalışanı Güncelle");
		butonguncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calisanguncelle();
				tabloyenile();
			}
		});

		JButton butonsil = new JButton("Çalışanı Sil");
		butonsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calisansil();
				tabloyenile();

			}
		});

		textarama = new JTextField();
		textarama.setColumns(10);

		textdepartman = new JTextField();
		textdepartman.setColumns(10);

		textmaas = new JTextField();
		textmaas.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Maaş:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);

		JButton butongoster = new JButton("Çalışanları göster");
		butongoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabloyenile();

			}
		});

		JScrollBar scrollBar = new JScrollBar();

		scrollPane = new JScrollPane();

		butonara = new JButton("ARA");
		butonara.setHorizontalAlignment(SwingConstants.LEADING);
		butonara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayitbul();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Departman");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton butonpzr = new JButton("Pazarlama");
		butonpzr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String departman="Pazarlama";
				sorgu(departman);
			}
		});
		
		JButton butonik = new JButton("İnsan Kaynakları");
		butonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String departman="İnsan Kaynakları";
					sorgu(departman);
			}
		});
		
		JButton butonbili = new JButton("Bilişim");
		butonbili.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String departman="Bilişim";
					sorgu(departman);
			}
		});
		
		JButton butonyon = new JButton("Yönetim");
		butonyon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String departman="Yönetim";
				sorgu(departman);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textarama, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(butonara))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(59)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textdepartman)
												.addComponent(textmaas, Alignment.TRAILING)
												.addComponent(textsoyad)
												.addComponent(textad, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
											.addGap(45)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(butonsil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(butonguncelle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(butongoster, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(butonekle, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))))
									.addGap(495))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(butonpzr)
							.addGap(18)
							.addComponent(butonik)
							.addGap(18)
							.addComponent(butonbili)
							.addGap(26)
							.addComponent(butonyon)))
					.addContainerGap(1080, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textarama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(butonara, 0, 0, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(butonekle))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(butonguncelle)
								.addComponent(textsoyad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textdepartman, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2))
						.addComponent(butonsil))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textmaas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(butongoster))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(butonpzr)
								.addComponent(butonik)
								.addComponent(butonbili)
								.addComponent(butonyon))
							.addGap(33)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)))
					.addGap(236))
		);

		tablo = new JTable();
		scrollPane.setViewportView(tablo);
		contentPane.setLayout(gl_contentPane);
	}

	public void tabloyenile() {
		try (Connection connection = DriverManager.getConnection(url, user, sifre)) {
			String query = "SELECT * FROM Calisanlar"; // Tablo adını doğrulayın
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			// DefaultTableModel oluşturuluyor
			DefaultTableModel model = new DefaultTableModel();
			tablo.setModel(model);

			// Sütun sayısı ve başlıkları alıyoruz
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			System.out.println("Sütun Sayısı: " + columnCount); // Hata ayıklama için ekledim

			// Sütun başlıklarını ekleyelim
			for (int i = 1; i <= columnCount; i++) {
				model.addColumn(metaData.getColumnName(i));
			}

			// Veri satırlarını ekliyoruz
			while (resultSet.next()) {
				Object[] row = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					row[i - 1] = resultSet.getObject(i);
				}
				model.addRow(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Veritabanına bağlanırken hata oluştu: " + e.getMessage(), "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void kayitbul() {
		String arama = textarama.getText(); // JTextField'e girilen değeri al
		try (Connection connection = DriverManager.getConnection(url, user, sifre)) {
			// SQL sorgusu, girilen değeri aramak için
			String query = "SELECT * FROM Calisanlar WHERE isim LIKE ? OR soyisim LIKE ?";
			DefaultTableModel model = new DefaultTableModel();
			tablo.setModel(model);
			model.addColumn("İsim");
			model.addColumn("Soyisim");
			model.addColumn("Departman");
			model.addColumn("Maaş");

			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				// Kullanıcı girişini parametre olarak kullan
				stmt.setString(1, "%" + arama + "%");
				stmt.setString(2, "%" + arama + "%");

				ResultSet resultSet = stmt.executeQuery();

				// Tabloyu temizle
				model.setRowCount(0);

				// Veritabanından gelen verileri tabloya ekle
				while (resultSet.next()) {
					Object[] row = new Object[4];

					row[0] = resultSet.getString("isim");
					row[1] = resultSet.getString("soyisim");
					row[2] = resultSet.getString("depertman");
					row[3] = resultSet.getString("maas");

					// Yeni satırı tabloya ekle
					model.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Veritabanına bağlanırken hata oluştu: " + e.getMessage(), "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void calisansil() {
		String query = "delete from Calisanlar where isim=? and soyisim=?";
		String isim = textad.getText();
		String soyisim = textsoyad.getText();

		try (Connection connection = DriverManager.getConnection(url, user, sifre);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			// Parametreleri sorguya ekleyin
			preparedStatement.setString(1, isim);
			preparedStatement.setString(2, soyisim);

			// Sorguyu çalıştırın (silme işlemi)
			int rowsAffected = preparedStatement.executeUpdate();

			// İşlemin başarılı olup olmadığını kontrol et
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Çalışan silindi", "BİLGİ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Çalışan bulunamadı", "HATA", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Beklenmedik bir hata oluştu: " + e.getMessage(), "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void calisanguncelle() {
		String isim = textad.getText();
	    String soyisim = textsoyad.getText();
	    String depertman= textdepartman.getText();
	    String maas = textmaas.getText();
	    
	    try (Connection connection = DriverManager.getConnection(url, user, sifre)) {
	        // SQL sorgusunda fazla WHERE kullanımı hatalıydı, onu düzelttik
	        String query = "UPDATE Calisanlar SET maas = ?  WHERE isim LIKE ? OR soyisim LIKE ?";
	        
	        PreparedStatement stmt = connection.prepareStatement(query);
	        
	        // Maaşın sayısal bir değer olduğunu varsayıyoruz, setDouble kullanıyoruz
	        stmt.setString(1, maas);  // 1. ?'ya maaş ekliyoruz
	        stmt.setString(2, "%" + isim + "%");  // 2. ?'ya isim ekliyoruz
	        stmt.setString(3, "%" + soyisim + "%");  // 3. ?'ya soyisim ekliyoruz
	        
	        int a = stmt.executeUpdate();
	        
	        if (a > 0) {
	            JOptionPane.showMessageDialog(this, "Güncellendi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "İsim ya da soyisim hatalı, güncellenemedi", "Hata", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Veritabanına bağlanırken hata oluştu: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
	    }}
    public void calisanekle() 
    {
    	String isim = textad.getText();
	    String soyisim = textsoyad.getText();
	    String departman = textdepartman.getText();
	    String maas = textmaas.getText();
	    try (Connection connection = DriverManager.getConnection(url, user, sifre)) {
	        // SQL sorgusunda fazla WHERE kullanımı hatalıydı, onu düzelttik
	        String query = "insert into Calisanlar(isim,soyisim,depertman,maas) values(?,?,?,?)";
	        
	        PreparedStatement stmt = connection.prepareStatement(query);
	        
	        // Maaşın sayısal bir değer olduğunu varsayıyoruz, setDouble kullanıyoruz
	        stmt.setString(1, isim);  // 1. ?'ya maaş ekliyoruz
	        stmt.setString(2,  soyisim );  // 2. ?'ya isim ekliyoruz
	        stmt.setString(3,  departman );  // 3. ?'ya soyisim ekliyoruz
	        stmt.setString(4,  maas );
	        
	        
	        int a = stmt.executeUpdate();
	        
	        if (a > 0) {
	            JOptionPane.showMessageDialog(this, "eklendi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, " güncellenemedi", "Hata", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Veritabanına bağlanırken hata oluştu: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
	    }
	  
    }
    public void sorgu(String a) {
    	
		try (Connection connection = DriverManager.getConnection(url, user, sifre)) {
			// SQL sorgusu, girilen değeri aramak için
			String query = "SELECT * FROM Calisanlar WHERE depertman= ? ";
			DefaultTableModel model = new DefaultTableModel();
			tablo.setModel(model);
			model.addColumn("İsim");
			model.addColumn("Soyisim");
			model.addColumn("Departman");
			model.addColumn("Maaş");
           
			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				// Kullanıcı girişini parametre olarak kullan
				stmt.setString(1,a);
				

				ResultSet resultSet = stmt.executeQuery();

				// Tabloyu temizle
				model.setRowCount(0);
		
				// Veritabanından gelen verileri tabloya ekle
				while (resultSet.next()) {
					Object[] row = new Object[4];

					row[0] = resultSet.getString("isim");
					row[1] = resultSet.getString("soyisim");
					row[2] = resultSet.getString("depertman");
					row[3] = resultSet.getString("maas");

					// Yeni satırı tabloya ekle
					model.addRow(row);
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Veritabanına bağlanırken hata oluştu: " + e.getMessage(), "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
    	
    }
    	
    	
    
}
