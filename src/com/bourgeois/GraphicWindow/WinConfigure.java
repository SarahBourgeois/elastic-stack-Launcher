package com.bourgeois.GraphicWindow;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.bourgeois.configuration.Configuration;

public class WinConfigure extends JFrame {
	private static final long serialVersionUID = 1L;

	public WinConfigure() throws HeadlessException {
		super();

		Configuration conn = new Configuration();
		Properties prop = new Properties();
		File fProp = new File("config.properties");

		// ==========================================
		// create principal pan
		// ==========================================
		JPanel principalPanConf = new JPanel();
		principalPanConf.setLayout(new GridLayout(4, 3));

		// ==========================================
		// first block : elasticsearch configuration
		// ==========================================
		JPanel fondElastic = new JPanel();
		fondElastic.setLayout(new GridLayout(3, 1));

		// ******** Host Elastic *******
		JPanel panElasticSaisiHost = new JPanel();
		panElasticSaisiHost.setLayout(new GridLayout(1, 3));

		// Text
		JLabel txt_elastic_host = new JLabel("your elasticsearch output host : ");
		panElasticSaisiHost.add(txt_elastic_host);
		fondElastic.add(panElasticSaisiHost);
		// Field
		JLabel sais_elastic_host = new JLabel(conn.getElasticHost());
		panElasticSaisiHost.add(sais_elastic_host);
		fondElastic.add(panElasticSaisiHost);
		// Buttons
		JButton btn_elastic_host = new JButton("edit");
		panElasticSaisiHost.add(btn_elastic_host);
		fondElastic.add(panElasticSaisiHost);

		// ******** Elastic Location *******
		JPanel panElasticSaisiLoc = new JPanel();
		panElasticSaisiLoc.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_elastic_loc = new JLabel("your elasticsearch location  : ");
		panElasticSaisiLoc.add(txt_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		// Field
		JLabel sais_elastic_loc = new JLabel(conn.getElasticLocation());
		panElasticSaisiLoc.add(sais_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		// Buttons
		JButton btn_elastic_loc = new JButton("edit");
		panElasticSaisiLoc.add(btn_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);

		// Custom
		fondElastic.setBorder(BorderFactory.createTitledBorder("ElasticSearch"));

		// ==========================================
		// second block : kibana configuration
		// ==========================================
		// secondary pan
		JPanel fondKibana = new JPanel();
		fondKibana.setLayout(new GridLayout(2, 1));

		// ******** Host Kibana *******
		JPanel panKibanaSaisiHost = new JPanel();
		panKibanaSaisiHost.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_kibana_host = new JLabel("your Kibana output host : ");
		panKibanaSaisiHost.add(txt_kibana_host);
		fondKibana.add(panKibanaSaisiHost);
		// Field
		JLabel sais_kibana_host = new JLabel(conn.getKibanaHost());
		panKibanaSaisiHost.add(sais_kibana_host);
		fondKibana.add(panKibanaSaisiHost);
		// Buttons
		JButton btn_kibana_host = new JButton("edit");
		panKibanaSaisiHost.add(btn_kibana_host);
		fondKibana.add(panKibanaSaisiHost);

		// ******** Kibana location *******
		JPanel panKibanaSaisiLoc = new JPanel();
		panKibanaSaisiLoc.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_kibana_loc = new JLabel("your Kibana location in computer : ");
		panKibanaSaisiLoc.add(txt_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Field
		JLabel sais_kibana_loc = new JLabel(conn.getKibanaLocation());
		panKibanaSaisiLoc.add(sais_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Button
		JButton btn_kibana_loc = new JButton("edit");
		panKibanaSaisiLoc.add(btn_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Custom
		fondKibana.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		fondKibana.setBorder(BorderFactory.createTitledBorder("Kibana"));

		// ==========================================
		// third block : log
		// ==========================================

		JPanel fondLog = new JPanel();
		fondLog.setLayout(new GridLayout(2, 1));

		// ******** Host Elastic *******
		JPanel panLogSaisi = new JPanel();
		panLogSaisi.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_log = new JLabel("your path log : ");
		panLogSaisi.add(txt_log);
		fondLog.add(panLogSaisi);
		// Field
		JLabel sai_log = new JLabel(conn.getPathLog());
		panLogSaisi.add(sai_log);
		fondLog.add(panLogSaisi);
		// Buttons
		JButton btn_log = new JButton("edit");
		panLogSaisi.add(btn_log);
		fondLog.add(panLogSaisi);
		// Custom
		fondLog.setBorder(BorderFactory.createTitledBorder("Logger Configuration"));

		// ==========================================
		// fourth block : kibana configuration
		// ==========================================

		JPanel fondValidate = new JPanel();
		fondValidate.setLayout(new GridLayout(1, 1));

		// Validate
		JPanel panValidate = new JPanel();
		panValidate.setLayout(new GridBagLayout());
		JButton btn_validate = new JButton("Exit");
		panValidate.add(btn_validate);
		fondValidate.add(panValidate);

		// ==========================================
		// Action listeners
		// ==========================================

		// *********** elastic Host ***************** **********
		btn_elastic_host.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit elasticsearch host", conn.getElasticHost());
				sais_elastic_host.setText(saisie);
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}

				String taNouvelleValeur = saisie;
				prop.setProperty("elastic.host", taNouvelleValeur);

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// *********** Elastic localization *****************
		btn_elastic_loc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit elasticsearch location",
						conn.getElasticLocation());
				sais_elastic_loc.setText(saisie);
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {

					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}

				String taNouvelleValeur = saisie;
				prop.setProperty("elastic.location", taNouvelleValeur);

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// *********** Log Configuration *****************
		btn_log.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String userConfig = JOptionPane.showInputDialog(null, "edit log path", conn.getPathLog());
				sai_log.setText(userConfig);

				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {

					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				String newValue = userConfig;
				prop.setProperty("path.log", newValue);

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, userConfig);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// *********** Kibana Host *****************
		btn_kibana_host.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String userConfig = JOptionPane.showInputDialog(null, "edit elasticsearch host", conn.getKibanaHost());
				sais_kibana_host.setText(userConfig);
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				String newValue = userConfig;
				prop.setProperty("kibana.host", newValue);
				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, userConfig);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});

		// *********** Location Kibana *****************
		btn_kibana_loc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit kibana location", conn.getKibanaLocation());
				sais_kibana_loc.setText(saisie);

				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				String taNouvelleValeur = saisie;
				prop.setProperty("kibana.location", taNouvelleValeur);
				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});

		// ******** Button validate **********
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});

		// ==========================================
		// add different pan to principal pan
		// ==========================================
		principalPanConf.add(fondElastic);
		principalPanConf.add(fondKibana);
		principalPanConf.add(fondLog);
		principalPanConf.add(fondValidate);
		this.setContentPane(principalPanConf);

		// ==========================================
		// Custom principal pan
		// ==========================================
		this.setTitle("Elastic stack Configuration");
		this.setSize(800, 530);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

	} // end of constructor



} // end of class
