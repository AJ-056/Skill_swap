import React from 'react';
import { render, unmountComponentAtNode } from 'react-dom';
import { act } from 'react-dom/test-utils';
import VoiceChatBot from '../src/VoiceChatBot'; // Adjust the import path as needed


describe('VoiceChatBot Component', () => {
  let container = null;
  beforeEach(() => {
    // setup a DOM element as a render target
    container = document.createElement("div");
    document.body.appendChild(container);
  });

  afterEach(() => {
    // cleanup on exiting
    unmountComponentAtNode(container);
    container.remove();
    container = null;

    // Clean up any added scripts to prevent interference with other tests
    const script = document.getElementById('chtl-script');
    if (script) {
      script.remove();
    }
    const config = document.querySelector('script[innerHTML*="window.chtlConfig"]');
      if (config) {
        config.remove();
      }
  });

  it('Verify that the Chatling script has the correct \'src\' attribute', () => {
    act(() => {
      render(<VoiceChatBot />, container);
    });

    const script = document.getElementById('chtl-script');
    expect(script).toBeDefined();
    expect(script.src).toBe('https://chatling.ai/js/embed.js');
  });

});