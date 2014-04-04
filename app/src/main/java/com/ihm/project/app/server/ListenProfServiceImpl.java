package com.ihm.project.app.server;

import java.io.IOException;
import java.util.List;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.LineUnavailableException;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import com.darkprograms.speech.recognizer.Recognizer.Languages;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ihm.project.app.client.service.ListenProfService;

@SuppressWarnings("serial")
public class ListenProfServiceImpl extends RemoteServiceServlet implements
		ListenProfService {
	private final Microphone microphone;
	private final Recognizer recognizer;

	public ListenProfServiceImpl() {
		this.microphone = new MicrophoneAnalyzer(Type.WAVE);
		this.recognizer = new Recognizer(Languages.FRENCH);
	}

	@Override
	public List<String> listen() throws LineUnavailableException,
			InterruptedException, IOException {
		this.microphone.open();

		this.microphone.captureAudioToFile("captureAt"
				+ System.currentTimeMillis());
		Thread.sleep(2000);
		this.microphone.close();

		GoogleResponse responses = this.recognizer
				.getRecognizedDataForWave(this.microphone.getAudioFile());
		return responses.getAllPossibleResponses();
	}

}
