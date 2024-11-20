import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class AplikasiCatatanHarian {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CatatanHarianFrame().setVisible(true);
        });
    }
}

// Frame utama aplikasi
class CatatanHarianFrame extends JFrame {
    private JTable tabelCatatan; // Tabel untuk menampilkan catatan
    private DefaultTableModel modelTabel; // Model untuk tabel
    private JTextField judulField; // Input untuk judul
    private JTextArea isiArea; // Input untuk isi catatan

    public CatatanHarianFrame() {
        // Pengaturan dasar frame
        setTitle("Aplikasi Catatan Harian");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Warna tema aplikasi
        Color warnaLatar = new Color(240, 248, 255); // Warna latar biru muda
        Color warnaPanel = new Color(176, 224, 230); // Warna panel biru keabu-abuan
        Color warnaTabelHeader = new Color(70, 130, 180); // Warna header tabel biru tua
        Color warnaTeks = Color.BLACK; // Warna teks hitam

        // Membuat model tabel
        modelTabel = new DefaultTableModel(new Object[]{"Judul", "Isi Catatan"}, 0);
        tabelCatatan = new JTable(modelTabel);
        tabelCatatan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Atur warna tabel
        tabelCatatan.setBackground(warnaLatar);
        tabelCatatan.setForeground(warnaTeks);
        tabelCatatan.setGridColor(Color.LIGHT_GRAY);
        tabelCatatan.getTableHeader().setBackground(warnaTabelHeader);
        tabelCatatan.getTableHeader().setForeground(Color.WHITE);

        // Mengatur lebar kolom
        TableColumnModel kolomModel = tabelCatatan.getColumnModel();
        kolomModel.getColumn(0).setPreferredWidth(150); // Kolom "Judul"
        kolomModel.getColumn(1).setPreferredWidth(450); // Kolom "Isi Catatan"

        JScrollPane scrollTabel = new JScrollPane(tabelCatatan);
        scrollTabel.setBackground(warnaLatar);
        add(scrollTabel, BorderLayout.WEST);

        // Panel untuk input data
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new BorderLayout());
        panelInput.setBorder(BorderFactory.createTitledBorder("Detail Catatan"));
        panelInput.setBackground(warnaPanel);

        judulField = new JTextField();
        judulField.setBackground(Color.WHITE);
        isiArea = new JTextArea(15, 20);
        isiArea.setLineWrap(true);
        isiArea.setWrapStyleWord(true);
        isiArea.setBackground(Color.WHITE);

        JScrollPane scrollIsi = new JScrollPane(isiArea);

        panelInput.add(new JLabel("Judul:"), BorderLayout.NORTH);
        panelInput.add(judulField, BorderLayout.CENTER);
        panelInput.add(new JLabel("Isi Catatan:"), BorderLayout.SOUTH);
        panelInput.add(scrollIsi, BorderLayout.SOUTH);

        add(panelInput, BorderLayout.CENTER);

        // Panel tombol aksi
        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.setBackground(warnaPanel);

        JButton tombolTambah = new JButton("Tambah");
        JButton tombolEdit = new JButton("Ubah");
        JButton tombolHapus = new JButton("Hapus");

        tombolTambah.setBackground(warnaTabelHeader);
        tombolTambah.setForeground(Color.WHITE);

        tombolEdit.setBackground(new Color(34, 139, 34)); // Warna hijau
        tombolEdit.setForeground(Color.WHITE);

        tombolHapus.setBackground(new Color(178, 34, 34)); // Warna merah
        tombolHapus.setForeground(Color.WHITE);

        panelTombol.add(tombolTambah);
        panelTombol.add(tombolEdit);
        panelTombol.add(tombolHapus);
        add(panelTombol, BorderLayout.SOUTH);

        // Event listener tombol Tambah
        tombolTambah.addActionListener(e -> {
            String judul = judulField.getText();
            String isi = isiArea.getText();
            if (!judul.isEmpty()) {
                modelTabel.addRow(new Object[]{judul, isi});
                kosongkanInput();
            } else {
                JOptionPane.showMessageDialog(this, "Judul tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Event listener tombol Ubah
        tombolEdit.addActionListener(e -> {
            int barisTerpilih = tabelCatatan.getSelectedRow();
            if (barisTerpilih != -1) {
                String judul = judulField.getText();
                String isi = isiArea.getText();
                if (!judul.isEmpty()) {
                    modelTabel.setValueAt(judul, barisTerpilih, 0);
                    modelTabel.setValueAt(isi, barisTerpilih, 1);
                    kosongkanInput();
                } else {
                    JOptionPane.showMessageDialog(this, "Judul tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin diubah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Event listener tombol Hapus
        tombolHapus.addActionListener(e -> {
            int barisTerpilih = tabelCatatan.getSelectedRow();
            if (barisTerpilih != -1) {
                modelTabel.removeRow(barisTerpilih);
                kosongkanInput();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Event listener untuk memilih baris di tabel
        tabelCatatan.getSelectionModel().addListSelectionListener(e -> {
            int barisTerpilih = tabelCatatan.getSelectedRow();
            if (barisTerpilih != -1) {
                judulField.setText((String) modelTabel.getValueAt(barisTerpilih, 0));
                isiArea.setText((String) modelTabel.getValueAt(barisTerpilih, 1));
            }
        });
    }

    // Metode untuk mengosongkan input
    private void kosongkanInput() {
        judulField.setText("");
        isiArea.setText("");
        tabelCatatan.clearSelection();
    }
}
