package org.rad.gui.dialog;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.rad.gui.model.Radlink;
import org.rad.kernel.translator.TranslatorEnum;
import org.rad.kernel.translator.cpp.parallel.CppThreadTranslator;

public class Options extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private Radlink model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Options dialog = new Options();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Options() {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 448, 0 };
		gridBagLayout.rowHeights = new int[] { 225, 35, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 53, 30, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Translator");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(TranslatorEnum.values()));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 0;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Threads");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 1;
			gbc_comboBox_1.gridy = 1;
			contentPanel.add(comboBox_1, gbc_comboBox_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Output file");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 2;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JButton btnOpen = new JButton("Open");
			btnOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fs = new JFileChooser();
					int retval = fs.showOpenDialog(Options.this);
					if (retval == JFileChooser.APPROVE_OPTION) {
						File f = fs.getSelectedFile();
						getOutputFile().setText(f.getAbsolutePath());
					}
				}
			});
			GridBagConstraints gbc_btnOpen = new GridBagConstraints();
			gbc_btnOpen.insets = new Insets(0, 0, 5, 0);
			gbc_btnOpen.gridx = 2;
			gbc_btnOpen.gridy = 2;
			contentPanel.add(btnOpen, gbc_btnOpen);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setData(model);
						model = null;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setup(Radlink model) {
		getTranslator().setSelectedItem(model.getTranslator());
		getThreadCount().setSelectedIndex(model.getThreadCount() - 1);
		getOutputFile().setText(model.getOutputFile());
		this.model = model;
	}

	public void setData(Radlink model) {
		model.setTranslator((TranslatorEnum) getTranslator().getSelectedItem());
		model.setThreadCount(getThreadCount().getSelectedIndex() + 1);
		if (model.getTranslator().getTranslator() instanceof CppThreadTranslator) {
			((CppThreadTranslator) model.getTranslator().getTranslator()).setThreadCount(model.getThreadCount());
		}
		model.setOutputFile(getOutputFile().getText());
	}

	protected JComboBox getThreadCount() {
		return comboBox_1;
	}

	protected JComboBox getTranslator() {
		return comboBox;
	}

	public JTextField getOutputFile() {
		return textField;
	}
}
