package patterns.adapter;

/**
 * Adapter Pattern Example
 * 
 * The Adapter pattern converts the interface of a class into another interface
 * clients expect. Adapter lets classes work together that couldn't otherwise
 * because of incompatible interfaces.
 */

// Target Interface - what the client expects
interface MediaPlayer {
    void play(String filename);
}

// Adaptee 1 - Existing class with incompatible interface
class VLCPlayer {
    public void playVLC(String filename) {
        System.out.println("Playing VLC file: " + filename);
    }
}

// Adaptee 2 - Another existing class with incompatible interface
class MP4Player {
    public void playMP4(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}

// Adaptee 3 - Legacy audio player
class LegacyAudioPlayer {
    public void playAudio(String filename, int volume) {
        System.out.println("Playing audio file: " + filename + " at volume: " + volume);
    }
}

// Adapter for VLC Player
class VLCAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer;

    public VLCAdapter() {
        this.vlcPlayer = new VLCPlayer();
    }

    @Override
    public void play(String filename) {
        vlcPlayer.playVLC(filename);
    }
}

// Adapter for MP4 Player
class MP4Adapter implements MediaPlayer {
    private MP4Player mp4Player;

    public MP4Adapter() {
        this.mp4Player = new MP4Player();
    }

    @Override
    public void play(String filename) {
        mp4Player.playMP4(filename);
    }
}

// Adapter for Legacy Audio Player
class LegacyAudioAdapter implements MediaPlayer {
    private LegacyAudioPlayer legacyPlayer;
    private int defaultVolume;

    public LegacyAudioAdapter(int defaultVolume) {
        this.legacyPlayer = new LegacyAudioPlayer();
        this.defaultVolume = defaultVolume;
    }

    @Override
    public void play(String filename) {
        legacyPlayer.playAudio(filename, defaultVolume);
    }
}

// Client class that uses the MediaPlayer interface
class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String filename) {
        MediaPlayer adapter;

        if (filename.endsWith(".vlc")) {
            adapter = new VLCAdapter();
        } else if (filename.endsWith(".mp4")) {
            adapter = new MP4Adapter();
        } else if (filename.endsWith(".wav") || filename.endsWith(".mp3")) {
            adapter = new LegacyAudioAdapter(75);
        } else {
            System.out.println("Unsupported format: " + filename);
            return;
        }

        adapter.play(filename);
    }
}

// Demo class
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        System.out.println("=== Media Player with Adapters ===\n");

        // Play different file formats through a unified interface
        player.play("movie.vlc");
        player.play("video.mp4");
        player.play("song.mp3");
        player.play("sound.wav");
        player.play("document.pdf"); // Unsupported format

        System.out.println("\n=== Using Adapters Directly ===\n");

        // Using adapters directly
        MediaPlayer vlcAdapter = new VLCAdapter();
        vlcAdapter.play("another_movie.vlc");

        MediaPlayer mp4Adapter = new MP4Adapter();
        mp4Adapter.play("another_video.mp4");
    }
}
