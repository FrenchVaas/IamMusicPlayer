package red.felnull.imp.client.gui.toasts;

/*
public class FFmpegLoadToast implements IToast {
    public static final ResourceLocation FFMPEGICON_TEXTURE = new ResourceLocation(IamMusicPlayer.MODID, "textures/gui/ffmpeg.png");
    private boolean completed;
    protected long compTime;

    @Override
    public Visibility func_230444_a_(MatrixStack matrix, ToastGui toast, long time) {

        FFmpegManeger maneger = FFmpegManeger.instance();
        FFmpegDownloader downloader = FFmpegDownloader.getInstance();

        Minecraft mc = toast.getMinecraft();
        FontRenderer fr = mc.fontRenderer;
        IKSGRenderUtil.matrixPush(matrix);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        IKSGRenderUtil.guiBindAndBlit(MusicUploadToast.IMP_TEXTURE_TOASTS, matrix, 0, 0, 0, 44, 160, 32, 256, 256);
        IKSGRenderUtil.matrixPop(matrix);

        IKSGRenderUtil.guiBindAndBlit(FFMPEGICON_TEXTURE, matrix, 8, 8, 0, 0, 16, 16, 16, 16);

        if (maneger.getState() == FFmpegManeger.FFmpegState.DOWNLOADING) {
            IKSGRenderUtil.guiBindAndBlit(MusicUploadToast.IMP_TEXTURE_TOASTS, matrix, 29, 19, 0, 32, 125, 7, 256, 256);
            IKSGRenderUtil.guiBindAndBlit(MusicUploadToast.IMP_TEXTURE_TOASTS, matrix, 30, 20, 0, 39, (int) (123 * downloader.getProgress()), 5, 256, 256);
            IKSGRenderUtil.matrixPush(matrix);
            IFormattableTextComponent tc = IKSGStyles.withStyle(new StringTextComponent((int) Math.ceil(downloader.getProgress() * 100) + "%"), IMPAbstractEquipmentScreen.smart_fontStyle);
            IKSGRenderUtil.matrixScalf(matrix, 0.5f);
            IKSGRenderUtil.drawCenterString(fr, matrix, tc, (int) (92.5f / 0.5f), (int) (20.5f / 0.5f), 0);
            IKSGRenderUtil.matrixPop(matrix);

            IKSGRenderUtil.drawString(fr, matrix, IKSGStyles.withStyle(maneger.getState().getLocalized(), IMPAbstractEquipmentScreen.smart_fontStyle), 29, 8, 0);
        } else {
            IKSGRenderUtil.drawString(fr, matrix, IKSGStyles.withStyle(new TranslationTextComponent("ffmpegtoast.completion"), IMPAbstractEquipmentScreen.smart_fontStyle), 29, 16 - fr.FONT_HEIGHT / 2, 0);
        }

        if (maneger.getState() != FFmpegManeger.FFmpegState.DOWNLOADING && maneger.getState() != FFmpegManeger.FFmpegState.EXTRACTING && maneger.getState() != FFmpegManeger.FFmpegState.PREPARATION) {
            if (!completed) {
                compTime = time;
                completed = true;
            }
            return time - compTime < 5000L ? IToast.Visibility.SHOW : IToast.Visibility.HIDE;
        }

        return IToast.Visibility.SHOW;
    }

    @Override
    public Object getType() {
        return FFmpegLoadToast.class;
    }

    public static boolean isAlreadyExists() {
        ToastGui toastgui = Minecraft.getInstance().getToastGui();
        FFmpegLoadToast tos = toastgui.getToast(FFmpegLoadToast.class, FFmpegLoadToast.class);
        return tos != null;
    }
}
*/