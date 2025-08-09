import React from 'react';
import { render, screen } from '@testing-library/react';
import App from '../App';
import { BrowserRouter } from 'react-router-dom';


describe('App Component', () => {
  it('renders without crashing', () => {
    render(
      <BrowserRouter>
        <App />
      </BrowserRouter>
    );
  });

  it('renders the LandingPage component', () => {
    render(
      <BrowserRouter>
        <App />
      </BrowserRouter>
    );
    const landingPageElement = screen.getByText(/SkillSwap/i); 
    expect(landingPageElement).toBeInTheDocument();
  });

  it('dynamically loads the ElevenLabs script', () => {
    render(
        <BrowserRouter>
            <App />
        </BrowserRouter>
    );

    const script = document.getElementById('elevenlabs-script');
    expect(script).toBeInTheDocument();
    expect(script.src).toBe('https://elevenlabs.io/convai-widget/index.js');
    expect(script.async).toBe(true);
    expect(script.type).toBe('text/javascript');

  });
});