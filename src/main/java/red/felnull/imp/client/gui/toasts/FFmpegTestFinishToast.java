package red.felnull.imp.client.gui.toasts;

/*
public class FFmpegTestFinishToast implements IToast {
    @Override
    public Visibility func_230444_a_(MatrixStack matrix, ToastGui toast, long time) {
        Minecraft mc = toast.getMinecraft();
        FontRenderer fr = mc.fontRenderer;

        IKSGRenderUtil.matrixPush(matrix);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        IKSGRenderUtil.guiBindAndBlit(MusicUploadToast.IMP_TEXTURE_TOASTS, matrix, 0, 0, 0, 44, 160, 32, 256, 256);
        IKSGRenderUtil.matrixPop(matrix);

        IKSGRenderUtil.guiBindAndBlit(FFmpegLoadToast.FFMPEGICON_TEXTURE, matrix, 8, 8, 0, 0, 16, 16, 16, 16);

        IKSGRenderUtil.drawString(fr, matrix, IKSGStyles.withStyle(new TranslationTextComponent("ffmpegtoast.testCompletion"), IMPAbstractEquipmentScreen.smart_fontStyle), 29, 16 - fr.FONT_HEIGHT / 2, 0);

        if (FFmpegManeger.instance().getState() == FFmpegManeger.FFmpegState.ERROR)
            return IToast.Visibility.HIDE;

        return time < 5000L ? IToast.Visibility.SHOW : IToast.Visibility.HIDE;
    }

    @Override
    public Object getType() {
        return FFmpegTestFinishToast.class;
    }

    public static boolean isAlreadyExists() {
        ToastGui toastgui = Minecraft.getInstance().getToastGui();
        FFmpegTestFinishToast tos = toastgui.getToast(FFmpegTestFinishToast.class, FFmpegTestFinishToast.class);
        return tos != null;
    }
}
*/