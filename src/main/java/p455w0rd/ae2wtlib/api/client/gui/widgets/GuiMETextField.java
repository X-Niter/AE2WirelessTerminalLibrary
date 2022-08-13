package p455w0rd.ae2wtlib.api.client.gui.widgets;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

/**
 * A modified version of the Minecraft text field.
 * You can initialize it over the full element span.
 * The mouse click area is increased to the full element
 * subtracted with the defined padding.
 *
 * The rendering does pay attention to the size of the '_' caret.
 */
public class GuiMETextField extends GuiTextField {

	private static final int PADDING = 2;

	private final int _xPos;
	private final int _yPos;
	private final int _width;
	private final int _height;
	private final int _fontPad;
	private int selectionColor = 0xFF00FF00;

	/**
	 * Uses the values to instantiate a padded version of a text field.
	 * Pays attention to the '_' caret.
	 *
	 * @param fontRenderer renderer for the strings
	 * @param xPos absolute left position
	 * @param yPos absolute top position
	 * @param width absolute width
	 * @param height absolute height
	 */
	public GuiMETextField(final FontRenderer fontRenderer, final int xPos, final int yPos, final int width, final int height) {
		super(0, fontRenderer, xPos + PADDING, yPos + PADDING, width - 2 * PADDING - fontRenderer.getCharWidth('_'), height - 2 * PADDING);
		_fontPad = fontRenderer.getCharWidth('_');
		_xPos = xPos;
		_yPos = yPos;
		_width = width;
		_height = height;
	}

	@Override
	public boolean mouseClicked(final int xPos, final int yPos, final int button) {
		super.mouseClicked(xPos, yPos, button);
		final boolean requiresFocus = isMouseIn(xPos, yPos);
		if (!isFocused()) {
			setFocused(requiresFocus);
		}
		return true;
	}

	public boolean isMouseIn(final int xCoord, final int yCoord) {
		final boolean withinXRange = _xPos <= xCoord && xCoord < _xPos + _width;
		final boolean withinYRange = _yPos <= yCoord && yCoord < _yPos + _height;
		return withinXRange && withinYRange;
	}

	public void selectAll() {
		setCursorPosition(0);
		setSelectionPos(getMaxStringLength());
	}

	public void setSelectionColor(final int color) {
		selectionColor = color;
	}

	@Override
	public void drawTextBox() {
		if (getVisible()) {
			if (isFocused()) {
				drawRect(x - PADDING + 1, y - PADDING + 1, x + width + _fontPad + PADDING - 1, y + height + PADDING - 1, 0xFF606060);
			}
			else {
				drawRect(x - PADDING + 1, y - PADDING + 1, x + width + _fontPad + PADDING - 1, y + height + PADDING - 1, 0xFFA8A8A8);
			}
			super.drawTextBox();
		}
	}

	@Override
	public void drawSelectionBox(int startX, int startY, int endX, int endY) {
		if (!isFocused()) {
			return;
		}
		if (startX < endX) {
			final int i = startX;
			startX = endX;
			endX = i;
		}
		startX += 1;
		endX -= 1;
		if (startY < endY) {
			final int j = startY;
			startY = endY;
			endY = j;
		}
		startY -= PADDING;
		if (endX > x + width) {
			endX = x + width;
		}
		if (startX > x + width) {
			startX = x + width;
		}
		final Tessellator tessellator = Tessellator.getInstance();
		final BufferBuilder bufferbuilder = tessellator.getBuffer();
		final float red = (selectionColor >> 16 & 255) / 255.0F;
		final float blue = (selectionColor >> 8 & 255) / 255.0F;
		final float green = (selectionColor & 255) / 255.0F;
		final float alpha = (selectionColor >> 24 & 255) / 255.0F;
		GlStateManager.color(red, green, blue, alpha);
		GlStateManager.disableTexture2D();
		GlStateManager.enableColorLogic();
		GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION);
		bufferbuilder.pos(startX, endY, 0.0D).endVertex();
		bufferbuilder.pos(endX, endY, 0.0D).endVertex();
		bufferbuilder.pos(endX, startY, 0.0D).endVertex();
		bufferbuilder.pos(startX, startY, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.disableColorLogic();
		GlStateManager.enableTexture2D();
	}

}