<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* nota/_formulario.html.twig */
class __TwigTemplate_1e59f26be55026b3c71b9dfc4e8e00d8 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "nota/_formulario.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "nota/_formulario.html.twig"));

        // line 1
        echo "<form action=\"";
        echo twig_escape_filter($this->env, (isset($context["action"]) || array_key_exists("action", $context) ? $context["action"] : (function () { throw new RuntimeError('Variable "action" does not exist.', 1, $this->source); })()), "html", null, true);
        echo "\" method=\"POST\">
  <div class=\"mb-3\">
    <label for=\"titulo\" class=\"form-label\">Título</label>
    <input type=\"text\" class=\"form-control\"
     id=\"titulo\" name=\"titulo\" value=\"";
        // line 5
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 5, $this->source); })()), "titulo", [], "any", false, false, false, 5), "html", null, true);
        echo "\">
  
  </div>

  <div class=\"mb-3\">
    <label for=\"desc\" class=\"form-label\">Descripción</label>
    <input type=\"text\" class=\"form-control\"
     id=\"desc\" name=\"desc\" value=\"";
        // line 12
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 12, $this->source); })()), "descripcion", [], "any", false, false, false, 12), "html", null, true);
        echo "\">
  
  </div>
  <button type=\"submit\" class=\"btn btn-primary\">Guardar</button>
</form>";
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName()
    {
        return "nota/_formulario.html.twig";
    }

    /**
     * @codeCoverageIgnore
     */
    public function isTraitable()
    {
        return false;
    }

    /**
     * @codeCoverageIgnore
     */
    public function getDebugInfo()
    {
        return array (  61 => 12,  51 => 5,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<form action=\"{{action}}\" method=\"POST\">
  <div class=\"mb-3\">
    <label for=\"titulo\" class=\"form-label\">Título</label>
    <input type=\"text\" class=\"form-control\"
     id=\"titulo\" name=\"titulo\" value=\"{{nota.titulo}}\">
  
  </div>

  <div class=\"mb-3\">
    <label for=\"desc\" class=\"form-label\">Descripción</label>
    <input type=\"text\" class=\"form-control\"
     id=\"desc\" name=\"desc\" value=\"{{nota.descripcion}}\">
  
  </div>
  <button type=\"submit\" class=\"btn btn-primary\">Guardar</button>
</form>", "nota/_formulario.html.twig", "C:\\Users\\mfernandez\\Documents\\ud8\\EjemploLibros\\Ejemplo_libros\\templates\\nota\\_formulario.html.twig");
    }
}
