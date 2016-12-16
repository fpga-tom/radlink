package org.rad.gui.cell;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mxgraph.model.mxCell;

public class CellProperties extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private mxCell model;
	private JComboBox type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CellProperties dialog = new CellProperties();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CellProperties() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setAlignment(FlowLayout.LEFT);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(null);
			contentPanel.add(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 169, 0 };
			gbl_panel.rowHeights = new int[] { 29, 34, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblName = new JLabel("Name");
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.anchor = GridBagConstraints.EAST;
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.gridx = 0;
				gbc_lblName.gridy = 0;
				panel.add(lblName, gbc_lblName);
			}
			{
				name = new JTextField();
				GridBagConstraints gbc_name = new GridBagConstraints();
				gbc_name.insets = new Insets(0, 0, 5, 0);
				gbc_name.fill = GridBagConstraints.HORIZONTAL;
				gbc_name.gridx = 1;
				gbc_name.gridy = 0;
				panel.add(name, gbc_name);
				name.setColumns(10);
			}
			{
				JLabel lblType = new JLabel("Type");
				GridBagConstraints gbc_lblType = new GridBagConstraints();
				gbc_lblType.anchor = GridBagConstraints.EAST;
				gbc_lblType.insets = new Insets(0, 0, 0, 5);
				gbc_lblType.gridx = 0;
				gbc_lblType.gridy = 1;
				panel.add(lblType, gbc_lblType);
			}
			{
				type = new JComboBox();
				type.setModel(new DefaultComboBoxModel(CellValueTypeEnum.values()));
				GridBagConstraints gbc_type = new GridBagConstraints();
				gbc_type.fill = GridBagConstraints.HORIZONTAL;
				gbc_type.gridx = 1;
				gbc_type.gridy = 1;
				panel.add(type, gbc_type);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateModel();
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void updateModel() {
		CellValue v = (CellValue) model.getValue();
		v.setName(name.getText());
		v.setValueType((CellValueTypeEnum) type.getSelectedItem());

	}

	protected void setupStep(mxCell c) {
		CellValue v = (CellValue) model.getValue();
		name.setText(v.getName());
		type.setSelectedItem(v.getValueType());

	}

	public mxCell getModel() {
		return model;
	}

	public void setModel(mxCell model) {
		this.model = model;
		setupStep(model);
	}
}
