package red.felnull.imp.client.data;

/*
@OnlyIn(Dist.CLIENT)
public class MusicUploader {
    private static MusicUploader INSTANCE;
    private final Map<String, MusicUploadData> stateDatas = new HashMap<>();

    public static void init() {
        INSTANCE = new MusicUploader();
    }

    public static MusicUploader instance() {
        return INSTANCE;
    }

    public void startUpload(String name, Path path, String uuid, PlayImage image, byte[] imageData) {
        startUpload(name, path, null, uuid, image, imageData);
    }

    public void startUpload(String name, URL url, String uuid, PlayImage image, byte[] imageData) {
        startUpload(name, null, url, uuid, image, imageData);
    }

    public void startUpload(String name, Path path, URL url, String uuid, PlayImage image, byte[] imageData) {
        stateDatas.put(uuid, new MusicUploadData(name, image, imageData));
        MusicUploadToast.add(uuid);
        if (path != null)
            upload(path, uuid);
        else if (url != null)
            upload(url, uuid);
    }


    protected void upload(URL url, String uuid) {
        try {
            setState(uuid, MusicUploadData.UploadState.CONVERTING);
            if (!conversion(url, uuid, 128)) {
                setState(uuid, MusicUploadData.UploadState.ERROR);
                return;
            }
            setState(uuid, MusicUploadData.UploadState.COMPRESSING);
            byte[] compdata = compressing(uuid);
            setState(uuid, MusicUploadData.UploadState.SENDING);
            setProgress(uuid, 0f);
            DataSendReceiverManager.instance().sendToServer(IMPWorldData.SERVER_MUSIC_DATA, uuid, compdata);
        } catch (Exception ex) {
            setState(uuid, MusicUploadData.UploadState.ERROR);
        }
    }

    protected void upload(Path path, String uuid) {
        try {
            setState(uuid, MusicUploadData.UploadState.CONVERTING);
            if (!conversion(path, uuid, 128)) {
                setState(uuid, MusicUploadData.UploadState.ERROR);
                return;
            }
            setState(uuid, MusicUploadData.UploadState.COMPRESSING);
            byte[] compdata = compressing(uuid);
            setState(uuid, MusicUploadData.UploadState.SENDING);
            setProgress(uuid, 0f);
            DataSendReceiverManager.instance().sendToServer(IMPWorldData.SERVER_MUSIC_DATA, uuid, compdata);
        } catch (Exception ex) {
            setState(uuid, MusicUploadData.UploadState.ERROR);
        }
    }

    private boolean conversion(URL url, String uuid, int bitrate) throws UnsupportedTagException, NotSupportedException, EncoderException, InvalidDataException, IOException, IMPFFmpegException {
        MultimediaObject mo = FFmpegUtils.createMultimediaObject(url);
        return conversion(mo, uuid, bitrate);
    }

    private boolean conversion(Path path, String uuid, int bitrate) throws UnsupportedTagException, NotSupportedException, EncoderException, InvalidDataException, IOException, IMPFFmpegException {
        MultimediaObject mo = FFmpegUtils.createMultimediaObject(path.toFile());
        return conversion(mo, uuid, bitrate);
    }

    private boolean conversion(MultimediaObject mo, String uuid, int bitrate) throws InvalidDataException, IOException, UnsupportedTagException, NotSupportedException, IMPFFmpegException {
        if (FFmpegUtils.getInfo(mo).getDuration() == -1)
            return false;
        IKSGFileLoadUtil.createFolder(PathUtils.getIMPTmpFolder());

        FFmpegUtils.encode(mo, PathUtils.getIMPTmpFolder().resolve(uuid + "-tmp").toFile(), "libmp3lame", bitrate, 2, 32000, "mp3", new EncoderProgressListener() {
            @Override
            public void sourceInfo(MultimediaInfo info) {
            }

            @Override
            public void progress(int permil) {
                setProgress(uuid, (float) permil / 1000f);
            }

            @Override
            public void message(String message) {
            }
        });

        Mp3File m3f = new Mp3File(PathUtils.getIMPTmpFolder().resolve(uuid + "-tmp").toFile());
        m3f.setId3v1Tag(new ID3v1Tag());
        m3f.setId3v2Tag(new ID3v24Tag());
        m3f.setCustomTag(new byte[0]);
        m3f.save(PathUtils.getIMPTmpFolder().resolve(uuid).toString());
        return true;
    }

    private byte[] compressing(String uuid) throws IOException {
        File file = PathUtils.getIMPTmpFolder().resolve(uuid).toFile();
        byte[] bytes = IKSGFileLoadUtil.fileBytesReader(file.toPath());
        IKSGFileLoadUtil.deleteFile(file);
        return IKSGDataUtil.gzZipping(bytes);
    }

    public boolean isUploaded(String uuid) {
        return stateDatas.containsKey(uuid);
    }

    public void setState(String uuid, MusicUploadData.UploadState state) {

        if (!stateDatas.containsKey(uuid))
            return;

        stateDatas.get(uuid).setState(state);
    }

    public void setProgress(String uuid, float parsent) {

        if (!stateDatas.containsKey(uuid))
            return;

        stateDatas.get(uuid).setProgress(parsent);
    }

    public MusicUploadData getStateData(String uuid) {
        return stateDatas.get(uuid);
    }

}
*/