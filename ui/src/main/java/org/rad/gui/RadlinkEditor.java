package org.rad.gui;

import java.awt.Color;
import java.awt.Point;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import org.rad.gui.cell.CellValue;
import org.rad.gui.cell.CellValueCodec;
import org.rad.gui.cell.CellValueTypeEnum;
import org.rad.gui.model.Radlink;
import org.w3c.dom.Document;

import com.mxgraph.examples.swing.GraphEditor;
import com.mxgraph.examples.swing.editor.BasicGraphEditor;
import com.mxgraph.examples.swing.editor.EditorMenuBar;
import com.mxgraph.examples.swing.editor.EditorPalette;
import com.mxgraph.io.mxCodec;
import com.mxgraph.io.mxCodecRegistry;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxICell;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxSwingConstants;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxResources;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxGraph;

public class RadlinkEditor extends BasicGraphEditor {

	public static final String appTitle = "Radlink";

	public static final CellValueTypeEnum type = CellValueTypeEnum.INHERITED;

	public static final NumberFormat numberFormat = NumberFormat.getInstance();

	private Radlink model;

	public RadlinkEditor() {
		this(appTitle, new CustomGraphComponent(new CustomGraph()));
	}

	public RadlinkEditor(String appTitle, mxGraphComponent component) {
		super(appTitle, component);
		model = new Radlink();
		EditorPalette palette = insertPalette(mxResources.get("commonly"));

		mxCodecRegistry.addPackage("org.rad.gui.cell");
		mxCodecRegistry.register(new CellValueCodec());

		palette.addTemplate("Delay", new ImageIcon(RadlinkEditor.class.getResource("/org/rad/gui/delay.png")),
				"roundImage;image=/org/rad/gui/delay.png", 40, 40, new CellValue("Delay", type));
		palette.addTemplate("Conj", new ImageIcon(RadlinkEditor.class.getResource("/org/rad/gui/conj.png")),
				"roundImage;image=/org/rad/gui/conj.png", 40, 40, new CellValue("Conj", type));
		palette.addTemplate("Mul", new ImageIcon(RadlinkEditor.class.getResource("/org/rad/gui/mul.png")),
				"roundImage;image=/org/rad/gui/mul.png", 40, 40, new CellValue("Mul", type));
		palette.addTemplate("Arg", new ImageIcon(RadlinkEditor.class.getResource("/org/rad/gui/arg.png")),
				"roundImage;image=/org/rad/gui/arg.png", 40, 40, new CellValue("Arg", type));
		palette.addTemplate("In", new ImageIcon(RadlinkEditor.class.getResource("/org/rad/gui/in.png")),
				"roundImage;image=/org/rad/gui/in.png", 40, 40, new CellValue("In", type));
		palette.addTemplate("Out", new ImageIcon(RadlinkEditor.class.getResource("/org/rad/gui/out.png")),
				"roundImage;image=/org/rad/gui/out.png", 40, 40, new CellValue("Out", type));

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		mxSwingConstants.SHADOW_COLOR = Color.LIGHT_GRAY;
		mxConstants.W3C_SHADOWCOLOR = "#D3D3D3";

		RadlinkEditor editor = new RadlinkEditor();
		editor.createFrame(new EditorMenuBar(editor)).setVisible(true);

	}

	public Radlink getModel() {
		return model;
	}

	public void setModel(Radlink model) {
		this.model = model;
	}

	public static class CustomGraphComponent extends mxGraphComponent {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6833603133512882012L;

		/**
		 * 
		 * @param graph
		 */
		public CustomGraphComponent(mxGraph graph) {
			super(graph);

			// Sets switches typically used in an editor
			setGridVisible(true);
			setToolTips(true);
			getConnectionHandler().setCreateTarget(true);

			// Loads the defalt stylesheet from an external file
			mxCodec codec = new mxCodec();
			Document doc = mxUtils.loadDocument(GraphEditor.class
					.getResource("/com/mxgraph/examples/swing/resources/default-style.xml").toString());
			codec.decode(doc.getDocumentElement(), graph.getStylesheet());

			// Sets the background to white
			getViewport().setOpaque(true);
			getViewport().setBackground(Color.WHITE);
		}

		/**
		 * Overrides drop behaviour to set the cell style if the target is not a
		 * valid drop target and the cells are of the same type (eg. both
		 * vertices or both edges).
		 */
		public Object[] importCells(Object[] cells, double dx, double dy, Object target, Point location) {
			if (target == null && cells.length == 1 && location != null) {
				target = getCellAt(location.x, location.y);

				if (target instanceof mxICell && cells[0] instanceof mxICell) {
					mxICell targetCell = (mxICell) target;
					mxICell dropCell = (mxICell) cells[0];

					if (targetCell.isVertex() == dropCell.isVertex() || targetCell.isEdge() == dropCell.isEdge()) {
						mxIGraphModel model = graph.getModel();
						model.setStyle(target, model.getStyle(cells[0]));
						graph.setSelectionCell(target);

						return null;
					}
				}
			}

			return super.importCells(cells, dx, dy, target, location);
		}

	}

	/**
	 * A graph that creates new edges from a given template edge.
	 */
	public static class CustomGraph extends mxGraph {
		/**
		 * Holds the edge to be used as a template for inserting new edges.
		 */
		protected Object edgeTemplate;

		/**
		 * Custom graph that defines the alternate edge style to be used when
		 * the middle control point of edges is double clicked (flipped).
		 */
		public CustomGraph() {
			setAlternateEdgeStyle("edgeStyle=mxEdgeStyle.ElbowConnector;elbow=vertical");
		}

		/**
		 * Sets the edge template to be used to inserting edges.
		 */
		public void setEdgeTemplate(Object template) {
			edgeTemplate = template;
		}

		/**
		 * Prints out some useful information about the cell in the tooltip.
		 */
		public String getToolTipForCell(Object cell) {
			String tip = "<html>";
			mxGeometry geo = getModel().getGeometry(cell);
			mxCellState state = getView().getState(cell);

			if (getModel().isEdge(cell)) {
				tip += "points={";

				if (geo != null) {
					List<mxPoint> points = geo.getPoints();

					if (points != null) {
						Iterator<mxPoint> it = points.iterator();

						while (it.hasNext()) {
							mxPoint point = it.next();
							tip += "[x=" + numberFormat.format(point.getX()) + ",y=" + numberFormat.format(point.getY())
									+ "],";
						}

						tip = tip.substring(0, tip.length() - 1);
					}
				}

				tip += "}<br>";
				tip += "absPoints={";

				if (state != null) {

					for (int i = 0; i < state.getAbsolutePointCount(); i++) {
						mxPoint point = state.getAbsolutePoint(i);
						tip += "[x=" + numberFormat.format(point.getX()) + ",y=" + numberFormat.format(point.getY())
								+ "],";
					}

					tip = tip.substring(0, tip.length() - 1);
				}

				tip += "}";
			} else {
				tip += "geo=[";

				if (geo != null) {
					tip += "x=" + numberFormat.format(geo.getX()) + ",y=" + numberFormat.format(geo.getY()) + ",width="
							+ numberFormat.format(geo.getWidth()) + ",height=" + numberFormat.format(geo.getHeight());
				}

				tip += "]<br>";
				tip += "state=[";

				if (state != null) {
					tip += "x=" + numberFormat.format(state.getX()) + ",y=" + numberFormat.format(state.getY())
							+ ",width=" + numberFormat.format(state.getWidth()) + ",height="
							+ numberFormat.format(state.getHeight());
				}

				tip += "]";
			}

			mxPoint trans = getView().getTranslate();

			tip += "<br>scale=" + numberFormat.format(getView().getScale()) + ", translate=[x="
					+ numberFormat.format(trans.getX()) + ",y=" + numberFormat.format(trans.getY()) + "]";
			tip += "</html>";

			return tip;
		}

		/**
		 * Overrides the method to use the currently selected edge template for
		 * new edges.
		 * 
		 * @param graph
		 * @param parent
		 * @param id
		 * @param value
		 * @param source
		 * @param target
		 * @param style
		 * @return
		 */
		public Object createEdge(Object parent, String id, Object value, Object source, Object target, String style) {
			if (edgeTemplate != null) {
				mxCell edge = (mxCell) cloneCells(new Object[] { edgeTemplate })[0];
				edge.setId(id);

				return edge;
			}

			return super.createEdge(parent, id, value, source, target, style);
		}

	}
}