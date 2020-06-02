\ProvidesClass{resume}[2010/07/10 v0.9 Resume class]

\LoadClass[11pt,letterpaper]{article} % Font size and paper type

\usepackage[parfill]{parskip} % Remove paragraph indentation
\usepackage{array} % Required for boldface (\bf and \bfseries) tabular columns
\usepackage{ifthen} % Required for ifthenelse statements
\usepackage{tikz}
\usepackage[left=0.75in,top=0.6in,right=0.75in,bottom=0.6in]{geometry} % Document margins


\pagestyle{empty} % Suppress page numbers

\newenvironment{NAME}[2]{
     \begin{center}
         \MakeUppercase{\huge\bf #1}  \MakeUppercase{\huge\bf #2}
     \end{center}
}

\newenvironment{INFO}[3]{
    \begin{center}
         { #1} \textbar \MakeUppercase{ #2} \textbar \MakeUppercase{ #3}
    \end{center}
}

\newenvironment{SUMMARY}[1]{
         { #1}
}

\newenvironment{DETAILS}[6]{
    \begin{center}
         { #1}, { #2}, { #3}, { #4}\\
         { #5} \textbar { #6}
    \end{center}
}

\newenvironment{BIRTH}[2]{
    \ifthenelse{\equal{#1}{}}{}{Date of birth: {#1}} \hfill
    \ifthenelse{\equal{#2}{}}{}{Place of birth: {#2}}
}

\newenvironment{NATIONALITY}[1]{
    \ifthenelse{\equal{#1}{}}{}{Nationality: {#1}}
}

\newenvironment{DRIVING}[1]{
    \ifthenelse{\equal{#1}{}}{}{Driving licence: {#1}}
}

\newenvironment{EDUCATION}[4]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} \hfill {#2} % Bold company name and date on the right
 \ifthenelse{\equal{#3}{}}{}{ % If the third argument is not specified, don't print the degree and location line
  \\
  {\em #3} \hfill {\em #4} % Italic degree and location
  }\smallskip
  \begin{list}{$\cdot$}{\leftmargin=0em} % \cdot used for bullets, no indentation
   \itemsep -0.5em \vspace{-0.5em} % Compress items in list together for aesthetics
  }{
  \end{list}
  \vspace{0.5em} % Some space after the list of bullet points
}


\newenvironment{WORK}[4]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} \hfill {#2} % Bold company name and date on the right
 \ifthenelse{\equal{#3}{}}{}{ % If the third argument is not specified, don't print the degree and location line
  \\
  { #3} \hfill { \em #4} % Italic degree and location
  }\smallskip
  \begin{list}{$\cdot$}{\leftmargin=0em} % \cdot used for bullets, no indentation
   \itemsep -0.5em \vspace{-0.5em} % Compress items in list together for aesthetics
  }{
  \end{list}
  \vspace{0.5em} % Some space after the list of bullet points
}

\newenvironment{ACTIVITY}[4]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} \hfill {#2} % Bold company name and date on the right
 \ifthenelse{\equal{#3}{}}{}{ % If the third argument is not specified, don't print the degree and location line
  \\
  { #3} \hfill { \em #4} % Italic degree and location
  }\smallskip
  \begin{list}{$\cdot$}{\leftmargin=0em} % \cdot used for bullets, no indentation
   \itemsep -0.5em \vspace{-0.5em} % Compress items in list together for aesthetics
  }{
  \end{list}
  \vspace{0.5em} % Some space after the list of bullet points
}

\newenvironment{REFERENCE}[4]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} from {\bf #2} \\ % Bold company name and date on the right
 { #3} \textbar { #4} % Your phone number and email

  \smallskip
}

\newenvironment{PROJECT}[3]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} \hfill {#2} % Bold company name and date on the right
 \ifthenelse{\equal{#3}{}}{}{ % If the third argument is not specified, don't print the degree and location line
  \\
  \hspace*{\fill} {\em #3}

  }\smallskip
  \begin{list}{$\cdot$}{\leftmargin=0em} % \cdot used for bullets, no indentation
   \itemsep -0.5em \vspace{-0.5em} % Compress items in list together for aesthetics
  }{
  \end{list}
  \vspace{0.5em} % Some space after the list of bullet points
}


\newenvironment{CUSTOM}[3]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} \hfill {#2} % Bold company name and date on the right
 \ifthenelse{\equal{#3}{}}{}{ % If the third argument is not specified, don't print the degree and location line
  \\
  \hspace*{\fill} {\em #3}

  }\smallskip
  \begin{list}{$\cdot$}{\leftmargin=0em} % \cdot used for bullets, no indentation
   \itemsep -0.5em \vspace{-0.5em} % Compress items in list together for aesthetics
  }{
  \end{list}
  \vspace{0.5em} % Some space after the list of bullet points
}

\newenvironment{COURSE}[3]{ % 4 input arguments - uni name, year(s), degree  and location
 {\bf #1} \hfill {#2} % Bold company name and date on the right
 \ifthenelse{\equal{#3}{}}{}{ % If the third argument is not specified, don't print the degree and location line
  \\
  { #3} % Italic degree and location
  }\smallskip
}

\newcommand{\itemmarker}{{\small\textbullet}}
\newcommand{\ratingmarker}{\faCircle}

\newcommand{\cvlink}[2]{%
\textbf{#1} \hfil {#2}\\
}


\newcommand{\cvskill}[2]{%
\textbf{#1} \hfill
\begin{tikzpicture}
       \draw (1,0) circle (0.2cm);
       \draw (2,0) circle (0.2cm);
       \draw (3,0) circle (0.2cm);
       \draw (4,0) circle (0.2cm);
       \draw (5,0) circle (0.2cm);
    \ifthenelse{\equal{#2}{1}}{
       \fill (1,0) circle (0.1cm);}{}
    \ifthenelse{\equal{#2}{2}}{
       \fill (1,0) circle (0.1cm);
       \fill (2,0) circle (0.1cm);
    }{}
    \ifthenelse{\equal{#2}{3}}{
       \fill (1,0) circle (0.1cm);
       \fill (2,0) circle (0.1cm);
       \fill (3,0) circle (0.1cm);
    }{}
    \ifthenelse{\equal{#2}{4}}{
       \fill (1,0) circle (0.1cm);
       \fill (2,0) circle (0.1cm);
       \fill (3,0) circle (0.1cm);
       \fill (4,0) circle (0.1cm);
    }{}
    \ifthenelse{\equal{#2}{5}}{
       \fill (1,0) circle (0.1cm);
       \fill (2,0) circle (0.1cm);
       \fill (3,0) circle (0.1cm);
       \fill (4,0) circle (0.1cm);
       \fill (5,0) circle (0.1cm);
    }{}
\end{tikzpicture}
}

\newenvironment{cvsection}[1]{ % 1 input argument - section name
  \medskip
  \MakeUppercase{\bf #1} % Section title
  \medskip
  \hrule % Horizontal line
  \begin{list}{}{ % List for each individual item in the section
    \setlength{\leftmargin}{1.5em} % Margin within the section
  }
  \item[]
}{
  \end{list}
}
