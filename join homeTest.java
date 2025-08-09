import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import JoinHome from '../JoinHome';

// Mock the useNavigate hook
const mockNavigate = jest.fn();
jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigate,
}));

describe('JoinHome Component', () => {
  beforeEach(() => {
    mockNavigate.mockClear();
  });

  it('renders without errors', () => {
    render(
      <BrowserRouter>
        <JoinHome />
      </BrowserRouter>
    );
    expect(screen.getByText('🎥 SkillSwap Live Session')).toBeInTheDocument();
  });

  it('navigates to /profile when Complete Your Profile button is clicked', () => {
    render(
      <BrowserRouter>
        <JoinHome />
      </BrowserRouter>
    );
    const completeProfileButton = screen.getByText('Complete Your Profile');
    fireEvent.click(completeProfileButton);
    expect(mockNavigate).toHaveBeenCalledWith('/profile');
  });

  it('navigates to /quiz when Take Quiz button is clicked', () => {
    render(
      <BrowserRouter>
        <JoinHome />
      </BrowserRouter>
    );
    const takeQuizButton = screen.getByText('Take Quiz');
    fireEvent.click(takeQuizButton);
    expect(mockNavigate).toHaveBeenCalledWith('/quiz');
  });

  it('navigates to /assistant when Open Chatbot button is clicked', () => {
    render(
      <BrowserRouter>
        <JoinHome />
      </BrowserRouter>
    );
    const openChatbotButton = screen.getByText('Open Chatbot');
    fireEvent.click(openChatbotButton);
    expect(mockNavigate).toHaveBeenCalledWith('/assistant');
  });

  it('appends the elevenlabs script to the document body', () => {
    render(
      <BrowserRouter>
        <JoinHome />
      </BrowserRouter>
    );
    const script = document.getElementById('elevenlabs-script');
    expect(script).toBeInTheDocument();
    expect(script?.src).toBe('https://elevenlabs.io/convai-widget/index.js');
    expect(script?.async).toBe(true);
    expect(script?.type).toBe('text/javascript');
  });
});