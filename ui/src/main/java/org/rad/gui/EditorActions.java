package org.rad.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxResources;

public class EditorActions {
	/**
	 * 
	 * @param e
	 * @return Returns the graph for the given action event.
	 */
	public static final RadlinkEditor getEditor(ActionEvent e) {
		if (e.getSource() instanceof Component) {
			Component component = (Component) e.getSource();

			while (component != null && !(component instanceof RadlinkEditor)) {
				component = component.getParent();
			}

			return (RadlinkEditor) component;
		}

		return null;
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class ExitAction extends AbstractAction {
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			RadlinkEditor editor = getEditor(e);

			if (editor != null) {
				editor.exit();
			}
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class ZoomPolicyAction extends AbstractAction {
		/**
		 * 
		 */
		protected int zoomPolicy;

		/**
		 * 
		 */
		public ZoomPolicyAction(int zoomPolicy) {
			this.zoomPolicy = zoomPolicy;
		}

		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof mxGraphComponent) {
				mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
				graphComponent.setPageVisible(true);
				graphComponent.setZoomPolicy(zoomPolicy);
			}
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class GridStyleAction extends AbstractAction {
		/**
		 * 
		 */
		protected int style;

		/**
		 * 
		 */
		public GridStyleAction(int style) {
			this.style = style;
		}

		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof mxGraphComponent) {
				mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
				graphComponent.setGridStyle(style);
				graphComponent.repaint();
			}
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class GridColorAction extends AbstractAction {
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof mxGraphComponent) {
				mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
				Color newColor = JColorChooser.showDialog(graphComponent, mxResources.get("gridColor"),
						graphComponent.getGridColor());

				if (newColor != null) {
					graphComponent.setGridColor(newColor);
					graphComponent.repaint();
				}
			}
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class ScaleAction extends AbstractAction {
		/**
		 * 
		 */
		protected double scale;

		/**
		 * 
		 */
		public ScaleAction(double scale) {
			this.scale = scale;
		}

		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof mxGraphComponent) {
				mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
				double scale = this.scale;

				if (scale == 0) {
					String value = (String) JOptionPane.showInputDialog(graphComponent, mxResources.get("value"),
							mxResources.get("scale") + " (%)", JOptionPane.PLAIN_MESSAGE, null, null, "");

					if (value != null) {
						scale = Double.parseDouble(value.replace("%", "")) / 100;
					}
				}

				if (scale > 0) {
					graphComponent.zoomTo(scale, graphComponent.isCenterZoom());
				}
			}
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class ToggleDirtyAction extends AbstractAction {
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof mxGraphComponent) {
				mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
				graphComponent.showDirtyRectangle = !graphComponent.showDirtyRectangle;
			}
		}

	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class HistoryAction extends AbstractAction {
		/**
		 * 
		 */
		protected boolean undo;

		/**
		 * 
		 */
		public HistoryAction(boolean undo) {
			this.undo = undo;
		}

		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			RadlinkEditor editor = getEditor(e);

			if (editor != null) {
				if (undo) {
					editor.getUndoManager().undo();
				} else {
					editor.getUndoManager().redo();
				}
			}
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("serial")
	public static class WarningAction extends AbstractAction {
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof mxGraphComponent) {
				mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
				Object[] cells = graphComponent.getGraph().getSelectionCells();

				if (cells != null && cells.length > 0) {
					String warning = JOptionPane.showInputDialog(mxResources.get("enterWarningMessage"));

					for (int i = 0; i < cells.length; i++) {
						graphComponent.setCellWarning(cells[i], warning);
					}
				} else {
					JOptionPane.showMessageDialog(graphComponent, mxResources.get("noCellSelected"));
				}
			}
		}
	}

}