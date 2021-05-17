package de.kaktushose.levelbot.database.services;

import de.kaktushose.levelbot.database.model.GuildSettings;
import de.kaktushose.levelbot.database.model.Rank;
import de.kaktushose.levelbot.database.model.Reward;
import de.kaktushose.levelbot.database.repositories.SettingsRepository;
import de.kaktushose.levelbot.spring.ApplicationContextHolder;
import org.springframework.context.ApplicationContext;

public class SettingsService {

    private SettingsRepository settingsRepository;

    public SettingsService() {
        ApplicationContext context = ApplicationContextHolder.getContext();
        this.settingsRepository = context.getBean(SettingsRepository.class);
    }

    private GuildSettings getGuildSettings(long guildId) {
        return settingsRepository.getGuildSettings(guildId).orElseThrow();
    }

    public long getBotChannelId(long guildId) {
        return getGuildSettings(guildId).getBotChannelId();
    }

    public String getBotPrefix(long guildId) {
        return getGuildSettings(guildId).getBotPrefix();
    }

    public String getBotToken(long guildId) {
        return getGuildSettings(guildId).getBotToken();
    }

    public String getVersion(long guildId) {
        return getGuildSettings(guildId).getVersion();
    }

    public long getMessageCooldown(long guildId) {
        return getGuildSettings(guildId).getMessageCooldown();
    }

    public boolean isIgnoredChannel(long channelId) {
        return settingsRepository.getIgnoredChannels().contains(channelId);
    }

    public long getShopChannelId(long guildId) {
        return getGuildSettings(guildId).getShopChannelId();
    }

    public void setShopChannelId(long guildId, long shopChannelId) {
        GuildSettings guildSettings = getGuildSettings(guildId);
        guildSettings.setShopChannelId(shopChannelId);
        settingsRepository.save(guildSettings);
    }

    public long getShopMessageId(long guildId) {
        return getGuildSettings(guildId).getShopMessageId();
    }

    public void setShopMessageId(long guildId, long shopMessageId) {
        GuildSettings guildSettings = getGuildSettings(guildId);
        guildSettings.setShopMessageId(shopMessageId);
        settingsRepository.save(guildSettings);
    }

    public Reward getMonthlyNitroBoosterReward() {
        return settingsRepository.getMonthlyNitroBoosterReward();
    }

    public Reward getOneTimeNitroBoosterReward() {
        return settingsRepository.getOneTimeNitroBoosterReward();
    }
}