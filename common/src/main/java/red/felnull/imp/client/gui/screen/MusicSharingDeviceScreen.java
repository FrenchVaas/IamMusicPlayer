package red.felnull.imp.client.gui.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import red.felnull.imp.IamMusicPlayer;
import red.felnull.imp.blockentity.MusicSharingDeviceBlockEntity;
import red.felnull.imp.client.gui.screen.msdscreen.MSDOffScreen;
import red.felnull.imp.inventory.MusicSharingDeviceMenu;

import java.util.HashMap;
import java.util.Map;

public class MusicSharingDeviceScreen extends IMPEquipmentBaseScreen<MusicSharingDeviceMenu> {
    private static final ResourceLocation MSD_LOCATION = new ResourceLocation(IamMusicPlayer.MODID, "textures/gui/container/music_sharing_device.png");
    private static final Map<MusicSharingDeviceBlockEntity.Screen, MonitorScreen> SCREENS = new HashMap<>();
    private MusicSharingDeviceBlockEntity.Screen lastScreen;

    public MusicSharingDeviceScreen(MusicSharingDeviceMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
        this.imageWidth = 215;
        this.imageHeight = 242;
        this.inventoryLabelY = this.imageHeight - 94;
        addScreens();
    }

    @Override
    protected void init() {
        super.init();
        this.lastScreen = getMonitorScreen();
        getCurrentScreen().enabled();
    }

    protected void addScreens() {
        addScreen(MusicSharingDeviceBlockEntity.Screen.OFF, new MSDOffScreen(this));
    }

    @Override
    public void tick() {
        super.tick();
        if (lastScreen != getMonitorScreen()) {
            SCREENS.get(lastScreen).disable();
            this.lastScreen = getMonitorScreen();
            getCurrentScreen().enabled();
        }
    }

    @Override
    protected ResourceLocation getBackGrandTextuer() {
        return MSD_LOCATION;
    }

    protected void addScreen(MusicSharingDeviceBlockEntity.Screen msdscreen, MonitorScreen screen) {
        SCREENS.put(msdscreen, screen);
    }

    public MusicSharingDeviceBlockEntity.Screen getMonitorScreen() {
        return getMSDEntity().getCurrentScreen(null);
    }

    public MonitorScreen getCurrentScreen() {
        return SCREENS.get(getMonitorScreen());
    }

    public MusicSharingDeviceBlockEntity getMSDEntity() {
        return (MusicSharingDeviceBlockEntity) getBlockEntity();
    }
}
