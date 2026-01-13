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
    mockNavigate.mockReset();
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
});